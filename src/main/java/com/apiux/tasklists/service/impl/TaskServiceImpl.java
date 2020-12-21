package com.apiux.tasklists.service.impl;

import com.apiux.tasklists.entity.Task;
import com.apiux.tasklists.repository.TaskRepository;
import com.apiux.tasklists.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    @Transactional
    public Task save(Task task) {
        return taskRepository.save(task);
    }

}
