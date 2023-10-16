package com.TenetTodoList.TodoList.controller;

import com.TenetTodoList.TodoList.domain.User;
import com.TenetTodoList.TodoList.dto.TodoListDTO;
import com.TenetTodoList.TodoList.dto.UserDTO;
import com.TenetTodoList.TodoList.services.UserService;
import com.TenetTodoList.TodoList.services.mappers.UserDTOMapperReverse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.TenetTodoList.TodoList.services.TodoService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {
    private final TodoService todoService;
private final UserService userService;
private final UserDTOMapperReverse userDTOMapperReverse;
    @Autowired
    public TodoController(TodoService todoService, UserService userService, UserDTOMapperReverse userDTOMapperReverse) {
        this.todoService = todoService;
        this.userService = userService;
        this.userDTOMapperReverse = userDTOMapperReverse;
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
        UserDTO userDTO = todoListDTO.user();

        if (userDTO == null || userDTO.id() == 0) {
            throw new RuntimeException("Invalid information");
        }

        // You need a method to convert UserDTO to User
        User user = userDTOMapperReverse.apply(userDTO);

        // Create a new TodoList entity
        TodoListDTO newTodo = new TodoListDTO(
                0,
                todoListDTO.description(),
                todoListDTO.status(),
                userDTO
        );

        return todoService.save(newTodo);
    }


    @PutMapping("/todolist/{todolistId}")
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

