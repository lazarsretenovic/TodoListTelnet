package com.TenetTodoList.ToDoList.controller;

import com.TenetTodoList.ToDoList.dto.ToDoListDTO;
import com.TenetTodoList.ToDoList.services.ToDoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "ToDo list:")
public class ToDoController {
    private final ToDoService todoService;
    public ToDoController(ToDoService todoService) {
        this.todoService = todoService;
    }
    @GetMapping("/todo_list")
    public ResponseEntity<List<ToDoListDTO>> findAll() {
        List<ToDoListDTO> toDoListDTOS = todoService.findAll();
        return new ResponseEntity<>(toDoListDTOS, HttpStatus.OK);
    }
    @GetMapping("/todo_list/{todoListId}")
    public ResponseEntity<ToDoListDTO> getTodo(@PathVariable Integer todoListId) {
        ToDoListDTO theTodoList = todoService.findById(todoListId);
        return new ResponseEntity<>(theTodoList, HttpStatus.OK);
    }
    @PostMapping("/todo_list")
    public ResponseEntity<ToDoListDTO> addTodo(@RequestBody ToDoListDTO todoListDTO) {
        ToDoListDTO savedTodoList = todoService.save_new(todoListDTO);
        return new ResponseEntity<>(savedTodoList, HttpStatus.CREATED);
    }
    @PutMapping("/todo_list/{todoListId}")
    public ResponseEntity<ToDoListDTO> updateTodo(@PathVariable Integer todoListId, @RequestBody ToDoListDTO updatedTodo) {
        ToDoListDTO updated = todoService.save(updatedTodo);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
    @DeleteMapping("/todo_list/{todoListId}")
    public ResponseEntity<String> deleteTodo(@PathVariable Integer todoListId) {
        ToDoListDTO theTodoList = todoService.findById(todoListId);
        todoService.deleteById(todoListId);
        return new ResponseEntity<>("Deleted todolist with id: " + todoListId, HttpStatus.OK);
    }
}

