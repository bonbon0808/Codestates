package com.example.todoapplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToDoAppController {

    @GetMapping("/")
    public String Text() {
        return "To-do Application !";
    }
}
