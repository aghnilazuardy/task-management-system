package backendtest.taskmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import backendtest.taskmanagementsystem.entity.Task;
import backendtest.taskmanagementsystem.model.CreateTaskRequest;
import backendtest.taskmanagementsystem.model.TaskResponse;
import backendtest.taskmanagementsystem.model.UpdateTaskRequest;
import backendtest.taskmanagementsystem.repository.TaskRepository;
import jakarta.transaction.Transactional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public TaskResponse create(CreateTaskRequest request){
        validationService.validate(request);

        Task task = new Task();
        task.setDetail(request.getDetail());
        task.setCompleted(request.getIsCompleted());

        taskRepository.save(task);

        return toTaskResponse(task);
    }

    private TaskResponse toTaskResponse(Task task) {
        return TaskResponse.builder()
            .id(task.getId())
            .detail(task.getDetail())
            .isCompleted(task.getIsCompleted())
            .build();            
    }

    @Transactional
    public TaskResponse updateStatus(UpdateTaskRequest request){
        // validationService.validate(request);

        Optional<Task> taskOptional = taskRepository.findById(request.getId());
        if (taskOptional.isPresent()) {
            // Modify the fields of the entity object
            Task task = taskOptional.get();
            task.setCompleted(request.isCompleted());
            
            // Save the entity
            taskRepository.save(task);

            return toTaskResponseUpdate(task);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID not found");
        }
    }

    private TaskResponse toTaskResponseUpdate(Task task) {
        return TaskResponse.builder()
            .id(task.getId())
            .detail(task.getDetail())
            .isCompleted(task.getIsCompleted())
            .build();            
    }

    @Transactional
    public List<TaskResponse> listTask(boolean status){
        List<Task> task = taskRepository.findAllByIsCompleted(status);

        return task.stream().map(this::toTaskResponseUpdate).toList();
    }
}
