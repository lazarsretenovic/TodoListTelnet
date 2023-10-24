package com.TenetTodoList.TodoList.controller;

import com.TenetTodoList.TodoList.domain.User;
import com.TenetTodoList.TodoList.dto.TodoListDTO;
import com.TenetTodoList.TodoList.dto.UserDTO;
import com.TenetTodoList.TodoList.services.TodoService;
import com.TenetTodoList.TodoList.services.UserService;
import com.TenetTodoList.TodoList.services.mappers.UserDTOMapperReverse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<TodoListDTO> findAll() {
        return todoService.findAll();
    }
    @GetMapping("/todo_list/{todolistId}")
    public TodoListDTO getTodo(@PathVariable int todolistId) {
        TodoListDTO theTodoList = todoService.findById(todolistId);
        if (theTodoList == null) {
            throw new RuntimeException("Todo list with that id doesnt exits\n id-" + todolistId);
        }
        return theTodoList;
    }
    @PostMapping("/todo_list")
    public TodoListDTO addTodo(@RequestBody TodoListDTO todoListDTO){
        TodoListDTO todoList=todoService.savenew(todoListDTO);
        return todoList;
    }
    @PutMapping("/todo_list/{todolistId}")
    public TodoListDTO updateTodo(@PathVariable int todolistId, @RequestBody TodoListDTO updatedTodo) {
        return todoService.save(updatedTodo);
    }

    @DeleteMapping("/todo_list/{todoListId}")
    public String deleteTodo(@PathVariable int todoListId) {
        TodoListDTO theTodoList = todoService.findById(todoListId);
        if (theTodoList == null) {
            throw new RuntimeException("Todo list by that id doesnt exit:" + todoListId);
        }
        todoService.deleteById(todoListId);
        return "Deleted todolist that had id of:" + todoListId;

    }


}

