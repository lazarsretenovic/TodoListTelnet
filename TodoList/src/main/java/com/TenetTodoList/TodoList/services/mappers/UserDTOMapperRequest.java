package com.TenetTodoList.TodoList.services.mappers;

import com.TenetTodoList.TodoList.domain.User;
import com.TenetTodoList.TodoList.dto.TodoListDTORequest;
import com.TenetTodoList.TodoList.dto.UserDTORequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class UserDTOMapperRequest implements Function<User, UserDTORequest> {

    private final UserDetailDTOMapperRequest userDetailDTOMapperRequest;
    private final TodoListDTOMapperRequest todoListDTOMapperRequest;

    public UserDTOMapperRequest(UserDetailDTOMapperRequest userDetailDTOMapperRequest, TodoListDTOMapperRequest todoListDTOMapperRequest) {
        this.userDetailDTOMapperRequest = userDetailDTOMapperRequest;
        this.todoListDTOMapperRequest = todoListDTOMapperRequest;
    }
    public UserDTORequest apply(User user) {
        List<TodoListDTORequest> todoListDTOs = user.getTodoList().stream()
                .map(todoListDTOMapperRequest::apply)
                .collect(Collectors.toList());

        return new UserDTORequest(
                user.getId(),
                user.getUsername(),
                userDetailDTOMapperRequest.apply(user.getUserDetail()),
                todoListDTOs
        );
    }
}
