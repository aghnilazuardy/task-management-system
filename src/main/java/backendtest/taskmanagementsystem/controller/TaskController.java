package backendtest.taskmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backendtest.taskmanagementsystem.model.CreateTaskRequest;
import backendtest.taskmanagementsystem.model.SumRequest;
import backendtest.taskmanagementsystem.model.TaskResponse;
import backendtest.taskmanagementsystem.model.UpdateTaskRequest;
import backendtest.taskmanagementsystem.model.WebResponse;
import backendtest.taskmanagementsystem.service.TaskService;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping(
        path = "/api/tasks",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<TaskResponse> create(@RequestBody CreateTaskRequest request){

        TaskResponse taskResponse = taskService.create(request);
        return WebResponse.<TaskResponse>builder().data(taskResponse).build();
    }

    @PostMapping(
        path = "/api/complete_task",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<TaskResponse> updateStatus(@RequestBody UpdateTaskRequest request){

        TaskResponse taskResponse = taskService.updateStatus(request);
        return WebResponse.<TaskResponse>builder().data(taskResponse).build();
    }

    @GetMapping(
        path = "/api/list/{isCompleted}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<List<TaskResponse>> listTask(@PathVariable("isCompleted") boolean isCompleted){

        List<TaskResponse> taskResponse = taskService.listTask(isCompleted);
        return WebResponse.<List<TaskResponse>>builder().data(taskResponse).build();
    }

    @PostMapping(
        path = "/api/sum"
    )
    public Integer sumEvenNumber(@RequestBody SumRequest request){
        int sum = 0;
        for (Integer number : request.getNumbers()) {   
            if (number%2 == 0) {
                sum += number;
            }
        };

        return sum;
    }
}
