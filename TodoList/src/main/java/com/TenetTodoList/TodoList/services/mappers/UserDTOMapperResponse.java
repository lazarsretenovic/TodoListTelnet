package com.TenetTodoList.TodoList.services.mappers;

import com.TenetTodoList.TodoList.domain.UserTodos;
import com.TenetTodoList.TodoList.dto.UserDTOResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@Component
public class UserDTOMapperResponse implements Function<UserTodos, UserDTOResponse> {

private final UserDetailDTOMapperResponse userDetailDTOMapperResponse;

    public UserDTOMapperResponse(UserDetailDTOMapperResponse userDetailDTOMapperResponse) {
        this.userDetailDTOMapperResponse = userDetailDTOMapperResponse;
    }

    public UserDTOResponse apply(UserTodos userTodos){
        return new UserDTOResponse(
                userTodos.getId(),
                userTodos.getUsername(),
               userDetailDTOMapperResponse.apply(userTodos.getUserDetail())

        );
    }
}
