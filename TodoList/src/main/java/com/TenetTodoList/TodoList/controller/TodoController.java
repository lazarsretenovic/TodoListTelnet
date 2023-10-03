package com.TenetTodoList.TodoList.controller;

import com.TenetTodoList.TodoList.domain.Todo;
import com.TenetTodoList.TodoList.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

@GetMapping("/todolist/{todolistId}")
    public Todo getTodo(@PathVariable int todolistId){
        Todo theTodo= todoService.findById(todolistId);
        if(theTodo==null){
            throw new RuntimeException("Todo list with that id doesnt exits\n id-"+ todolistId);
        }
        return theTodo;
}

    @PostMapping("/todolist")
    public Todo addTodo(@RequestBody Todo theTodo){
        theTodo.setId(0);
        Todo todo= todoService.save(theTodo);
        return todo;
    }



}

