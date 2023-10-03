package com.TenetTodoList.TodoList.controller;

import com.TenetTodoList.TodoList.domain.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.TenetTodoList.TodoList.services.TodoService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {
    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todolist")
    public List<Todo> findAll(){
        return todoService.findAll();
    }




}

