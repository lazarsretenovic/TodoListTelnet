package com.TenetTodoList.TodoList.services.mappers;

import com.TenetTodoList.TodoList.domain.User;
import com.TenetTodoList.TodoList.dto.UserDTOResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@Component
public class UserDTOMapperResponse implements Function<User, UserDTOResponse> {

private final UserDetailDTOMapperResponse userDetailDTOMapperResponse;

    public UserDTOMapperResponse(UserDetailDTOMapperResponse userDetailDTOMapperResponse) {
        this.userDetailDTOMapperResponse = userDetailDTOMapperResponse;
    }

    public UserDTOResponse apply(User user){
        return new UserDTOResponse(
                user.getUsername(),
               userDetailDTOMapperResponse.apply(user.getUserDetail())

        );
    }
}
