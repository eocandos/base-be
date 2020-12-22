package com.apiux.tasklists.service.impl;

import com.apiux.tasklists.entity.Task;
import com.apiux.tasklists.enums.ResultEnum;
import com.apiux.tasklists.exception.MyException;
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

    public Task findOne(Long id) {
        return taskRepository.findByTaskId(id);
    }

    @Override
    @Transactional
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    @Transactional
    public Task update(Task task) {
        return taskRepository.save(task);
    }

    @Override
    @Transactional
    public Task setState(Long taskId) {
        Task task = findOne(taskId);
        if (task == null) throw new MyException(ResultEnum.TASK_NOT_EXIST);
        task.setActive(!task.isActive());
        return update(task);
    }

    @Override
    public void delete(Long taskId) {
        Task task = findOne(taskId);
        if (task == null) throw new MyException(ResultEnum.TASK_NOT_EXIST);
        taskRepository.delete(task);
    }

}
