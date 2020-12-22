package com.apiux.tasklists.service;

import com.apiux.tasklists.entity.Task;
import java.util.List;

public interface TaskService {
    List<Task> findAll();

    Task findOne(Long taskId);

    Task save(Task task);

    Task update(Task task);

    void delete(Long taskId);
}
