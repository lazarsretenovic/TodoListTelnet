package com.TenetTodoList.TodoList.services.mappers;

import com.TenetTodoList.TodoList.domain.UserDetail;
import com.TenetTodoList.TodoList.dto.UserDetailDTORequest;
import com.TenetTodoList.TodoList.dto.UserDetailDTOResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserDetailDTOMapperRequest implements Function<UserDetail, UserDetailDTORequest> {
    public UserDetailDTORequest apply(UserDetail userDetail){
        return new UserDetailDTORequest(
                userDetail.getId(),
                userDetail.getFirstName(),
                userDetail.getLastName(),
                userDetail.getEmail(),
                userDetail.getCity()
        );
    }
}
