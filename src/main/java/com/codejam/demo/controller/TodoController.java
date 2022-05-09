package com.codejam.demo.controller;


import com.codejam.demo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/todo")
public class TodoController {

    @Autowired
    private final TodoService todoService;

    @GetMapping("/")
    ResponseEntity<String> getTodo(@RequestParam int id) {
       return todoService.getTodo(id);
    }

}
