package com.TenetTodoList.TodoList.services.mappers;

import com.TenetTodoList.TodoList.domain.User;
import com.TenetTodoList.TodoList.dto.UserDTORequest;
import com.TenetTodoList.TodoList.dto.UserDTOResponse;
import com.TenetTodoList.TodoList.dto.UserDetailDTORequest;
import com.TenetTodoList.TodoList.dto.UserDetailDTOResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@Component
public class UserDTOMapperRequest implements Function<User, UserDTORequest> {

    private final UserDetailDTOMapperRequest userDetailDTOMapperRequest;


    public UserDTOMapperRequest(UserDetailDTOMapperRequest userDetailDTOMapperRequest) {
        this.userDetailDTOMapperRequest = userDetailDTOMapperRequest;
    }

    public UserDTORequest apply(User user){
        return new UserDTORequest(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                userDetailDTOMapperRequest.apply(user.getUserDetail())

        );
    }
}
