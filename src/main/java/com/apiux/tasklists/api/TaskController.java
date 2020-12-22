package com.apiux.tasklists.api;

import com.apiux.tasklists.entity.Task;
import com.apiux.tasklists.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@EnableAutoConfiguration
public class TaskController {

    @Autowired
    TaskService taskService;

    @RequestMapping("/tasks")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(taskService.findAll());
    }

    @PostMapping("/task")
    public Task create(@RequestBody Task task) {
        return taskService.save(task);
    }

    @PutMapping("/task/{id}/edit")
    public ResponseEntity edit(@PathVariable("id") Long taskId,
                               @Valid @RequestBody Task task) {
        task.setTaskId(taskId);
        return ResponseEntity.ok(taskService.update(task));
    }


    @DeleteMapping("/task/{id}")
    public ResponseEntity delete(@PathVariable("id") Long taskId) {
        taskService.delete(taskId);
        return ResponseEntity.ok().build();
    }
}
