package com.TenetTodoList.ToDoList.controller;

import com.TenetTodoList.ToDoList.dto.ToDoListDTOResponse;
import com.TenetTodoList.ToDoList.services.ToDoServiceResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Todo list response:")

public class ToDoResponseController {
    private final ToDoServiceResponse todoService;
    public ToDoResponseController(ToDoServiceResponse todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todo_list_response")
    public ResponseEntity<List<ToDoListDTOResponse>> findAll() {
        List<ToDoListDTOResponse> toDoListDTORespons = todoService.findAll();
        return new ResponseEntity<>(toDoListDTORespons, HttpStatus.OK);
    }
}