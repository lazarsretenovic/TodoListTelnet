package com.TenetTodoList.TodoList.controller;

import com.TenetTodoList.TodoList.domain.TodoList;
import com.TenetTodoList.TodoList.dto.TodoListDTO;
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
    public List<TodoListDTO> findAll(){
        return todoService.findAll();
    }

@GetMapping("/todolist/{todolistId}")
    public TodoListDTO getTodo(@PathVariable int todolistId){
        TodoListDTO theTodoList = todoService.findById(todolistId);
        if(theTodoList ==null){
            throw new RuntimeException("Todo list with that id doesnt exits\n id-"+ todolistId);
        }
        return theTodoList;
}

    @PostMapping("/todolist")
    public TodoListDTO addTodo(@RequestBody TodoListDTO theTodoList){
        theTodoList.setId(0);
        TodoListDTO todoList = todoService.save(theTodoList);
        return todoList;
    }
    @PutMapping("/todolist")
    public TodoListDTO updateTodo(@RequestBody TodoListDTO theTodoList){
        TodoListDTO todoList =todoService.save(theTodoList);
        return todoList;
    }
    @DeleteMapping("/todolist/{todoListId}")
    public String deleteTodo(@PathVariable int todoListId){
        TodoListDTO theTodoList = todoService.findById(todoListId);
        if(theTodoList ==null){
            throw new RuntimeException("Todo list by that id doesnt exit:"+todoListId);
        }

        todoService.deleteById(todoListId);
        return "Deleted todolist that had id of:"+ todoListId;

    }



}

