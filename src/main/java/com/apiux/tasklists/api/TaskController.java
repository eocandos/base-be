package com.apiux.tasklists.api;

import com.apiux.tasklists.entity.Task;
import com.apiux.tasklists.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@EnableAutoConfiguration
public class TaskController {

    @Autowired
    TaskService taskService;

    @RequestMapping("/task")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(taskService.findAll());
    }

    @GetMapping("/task/{taskId}")
    public ResponseEntity showOne(@PathVariable("taskId") Long taskId) {
        return ResponseEntity.ok(taskService.findOne(taskId));
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

    @PutMapping("/task/{id}/change-state")
    public ResponseEntity changeState(@PathVariable("id") Long taskId) {
         return ResponseEntity.ok(taskService.setState(taskId));
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity delete(@PathVariable("id") Long taskId) {
        taskService.delete(taskId);
        return ResponseEntity.ok().build();
    }
}
