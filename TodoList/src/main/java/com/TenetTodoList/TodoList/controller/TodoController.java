package com.TenetTodoList.TodoList.controller;

import com.TenetTodoList.TodoList.dto.TodoListDTO;
import com.TenetTodoList.TodoList.dto.UserDTO;
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
    public TodoListDTO addTodo(@RequestBody TodoListDTO todoListDTO) {
        // Ensure the user_id in TodoListDTO is set
        UserDTO userDTO = todoListDTO.user();

        if (userDTO == null || userDTO.id() == 0) {
            // Handle the case where the user information is missing or invalid
            throw new RuntimeException("User information is missing or invalid");
        }

        // The user_id field in TodoListDTO should be set to a valid user ID

        // Now, save the TodoList
        TodoListDTO savedTodo = todoService.save(todoListDTO);

        return savedTodo;
    }
    @PutMapping("/{todolistId}")
    public TodoListDTO updateTodo(@PathVariable int todolistId, @RequestBody TodoListDTO updatedTodo) {
        return todoService.save(updatedTodo);
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

