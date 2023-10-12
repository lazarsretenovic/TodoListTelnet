package com.TenetTodoList.TodoList.services.mappers;

import com.TenetTodoList.TodoList.domain.TodoList;
import com.TenetTodoList.TodoList.domain.UserTodos;
import com.TenetTodoList.TodoList.dto.UserDTORequest;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserDTOMapperRequestReverse {
    public UserTodos map(UserDTORequest userDTO) {
        UserTodos userTodos = new UserTodos();
        userTodos.setId(userDTO.id());
        userTodos.setUser_name(userDTO.username());
        userTodos.setPassword(userDTO.password());

        // Assuming you have a method in your User class to set the todoList field.
        // This method sets the todoList by mapping TodoListDTORequest to TodoList entities.
        userTodos.setTodoList(userDTO.todos()
                .stream()
                .map(todoDTO -> {
                    TodoList todoList = new TodoList();
                    return todoList;
                })
                .collect(Collectors.toList()));

        return userTodos;
    }
}
