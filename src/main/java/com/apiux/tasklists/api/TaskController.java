package com.apiux.tasklists.api;

import com.apiux.tasklists.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class TaskController {

    @Autowired
    TaskService taskService;

    @RequestMapping("/")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(taskService.findAll());
        // return "Hello World Spring Boot!";
    }
}
