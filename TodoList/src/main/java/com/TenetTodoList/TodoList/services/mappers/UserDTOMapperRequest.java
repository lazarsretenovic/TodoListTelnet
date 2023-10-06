package com.TenetTodoList.TodoList.services.mappers;

import com.TenetTodoList.TodoList.domain.User;
import com.TenetTodoList.TodoList.dto.UserDTORequest;
import com.TenetTodoList.TodoList.dto.TodoListDTORequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDTOMapperRequest {

    @Autowired
    private UserDetailDTOMapperRequest userDetailDTOMapperRequest;
    @Autowired
    private TodoListDTOMapperRequest todoListDTOMapperRequest;


    public UserDTORequest apply(User user) {
        List<TodoListDTORequest> todoListDTOs = user.getTodoList().stream()
                .map(todoListDTOMapperRequest::apply)
                .collect(Collectors.toList());

        return new UserDTORequest(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                userDetailDTOMapperRequest.apply(user.getUserDetail()),
                todoListDTOs
        );
    }
}
