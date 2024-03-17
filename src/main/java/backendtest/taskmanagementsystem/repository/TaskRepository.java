package backendtest.taskmanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backendtest.taskmanagementsystem.entity.Task;


@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findAllByIsCompleted(boolean isCompleted);
}
