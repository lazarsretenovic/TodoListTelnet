package com.TenetTodoList.TodoList.controller;

import com.TenetTodoList.TodoList.dto.TodoListDTOResponse;
import com.TenetTodoList.TodoList.services.TodoServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoControllerResponse {
    @Autowired
    private TodoServiceResponse todoService;



    @GetMapping("/todolistresponse")
    public List<TodoListDTOResponse> findAll() {
        return todoService.findAll();
    }
}