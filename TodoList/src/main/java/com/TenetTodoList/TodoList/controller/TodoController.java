package com.TenetTodoList.TodoList.controller;

import com.TenetTodoList.TodoList.dto.TodoListDTO;
import com.TenetTodoList.TodoList.services.TodoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Todo list:")
public class TodoController {
    private final TodoService todoService;
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
    @GetMapping("/todo_list")
    public ResponseEntity<List<TodoListDTO>> findAll() {
        List<TodoListDTO> todoListDTOs = todoService.findAll();
        return new ResponseEntity<>(todoListDTOs, HttpStatus.OK);
    }
    @GetMapping("/todo_list/{todoListId}")
    public ResponseEntity<TodoListDTO> getTodo(@PathVariable Integer todoListId) {
        TodoListDTO theTodoList = todoService.findById(todoListId);
        return new ResponseEntity<>(theTodoList, HttpStatus.OK);
    }
    @PostMapping("/todo_list")
    public ResponseEntity<TodoListDTO> addTodo(@RequestBody TodoListDTO todoListDTO) {
        TodoListDTO savedTodoList = todoService.save_new(todoListDTO);
        return new ResponseEntity<>(savedTodoList, HttpStatus.CREATED);
    }
    @PutMapping("/todo_list/{todoListId}")
    public ResponseEntity<TodoListDTO> updateTodo(@PathVariable Integer todoListId, @RequestBody TodoListDTO updatedTodo) {
        TodoListDTO updated = todoService.save(updatedTodo);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
    @DeleteMapping("/todo_list/{todoListId}")
    public ResponseEntity<String> deleteTodo(@PathVariable Integer todoListId) {
        TodoListDTO theTodoList = todoService.findById(todoListId);
        todoService.deleteById(todoListId);
        return new ResponseEntity<>("Deleted todolist with id: " + todoListId, HttpStatus.OK);
    }
}

