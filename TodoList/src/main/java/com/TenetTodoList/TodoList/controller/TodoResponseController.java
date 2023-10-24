package com.TenetTodoList.TodoList.controller;

import com.TenetTodoList.TodoList.dto.TodoListDTOResponse;
import com.TenetTodoList.TodoList.services.TodoServiceResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Todo list response:")

public class TodoResponseController {
    private final TodoServiceResponse todoService;
    public TodoResponseController(TodoServiceResponse todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todo_list_response")
    public List<TodoListDTOResponse> findAll() {
        return todoService.findAll();
    }
}