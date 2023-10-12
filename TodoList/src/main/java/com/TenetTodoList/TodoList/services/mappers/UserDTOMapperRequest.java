package com.TenetTodoList.TodoList.services.mappers;

import com.TenetTodoList.TodoList.domain.UserTodos;
import com.TenetTodoList.TodoList.dto.UserDTORequest;
import com.TenetTodoList.TodoList.dto.TodoListDTORequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class UserDTOMapperRequest implements Function<UserTodos, UserDTORequest> {

    private final UserDetailDTOMapperRequest userDetailDTOMapperRequest;
    private final TodoListDTOMapperRequest todoListDTOMapperRequest;

    @Autowired
    public UserDTOMapperRequest(
            UserDetailDTOMapperRequest userDetailDTOMapperRequest,
            TodoListDTOMapperRequest todoListDTOMapperRequest) {
        this.userDetailDTOMapperRequest = userDetailDTOMapperRequest;
        this.todoListDTOMapperRequest = todoListDTOMapperRequest;
    }

    public UserDTORequest apply(UserTodos userTodos) {
        List<TodoListDTORequest> todoListDTOs = userTodos.getTodoList().stream()
                .map(todoListDTOMapperRequest::apply)
                .collect(Collectors.toList());

        return new UserDTORequest(
                userTodos.getId(),
                userTodos.getUsername(),
                userTodos.getPassword(),
                userDetailDTOMapperRequest.apply(userTodos.getUserDetail()),
                todoListDTOs
        );
    }
}
