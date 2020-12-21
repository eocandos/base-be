package com.apiux.tasklists.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class TaskController {

    @RequestMapping("/")
    String home() {
        return "Hello World Spring Boot!";
    }
}
