package com.codejam.demo.controller;


import com.codejam.demo.constants.PathConstants;
import com.codejam.demo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = PathConstants.RESOURCE_PATH)
public class TodoController {

    @Autowired
    private final TodoService todoService;

    @GetMapping(path = PathConstants.TODO_PATH)
    ResponseEntity<String> getTodo(@PathVariable int id) {
       return todoService.getTodo(id);
    }

}
