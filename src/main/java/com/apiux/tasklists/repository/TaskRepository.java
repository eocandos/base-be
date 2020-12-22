package com.apiux.tasklists.repository;

import com.apiux.tasklists.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAll();

    Task findByTaskId(Long id);

}
