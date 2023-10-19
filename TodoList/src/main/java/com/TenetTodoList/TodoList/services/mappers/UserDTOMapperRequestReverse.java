package com.TenetTodoList.TodoList.services.mappers;

import com.TenetTodoList.TodoList.domain.TodoList;
import com.TenetTodoList.TodoList.domain.User;
import com.TenetTodoList.TodoList.dto.UserDTORequest;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserDTOMapperRequestReverse {
    public User map(UserDTORequest userDTO) {
        User user = new User();
        user.setId(userDTO.id());
        user.setLoginname(userDTO.login_name());
        user.setTodoList(userDTO.todos()
                .stream()
                .map(todoDTO -> {
                    TodoList todoList = new TodoList();
                    return todoList;
                })
                .collect(Collectors.toList()));

        return user;
    }
}
