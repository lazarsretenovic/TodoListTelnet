package com.TenetTodoList.TodoList.services;

import com.TenetTodoList.TodoList.domain.UserDetail;
import com.TenetTodoList.TodoList.dto.UserDetailDto;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@Component
public class UserDetailDTOMapper implements Function<UserDetail, UserDetailDto> {
    public UserDetailDto apply(UserDetail userDetail){
        return new UserDetailDto(
                userDetail.getId(),
                userDetail.getFirstName(),
                userDetail.getLastName(),
                userDetail.getCity(),
                userDetail.getEmail()
        );
    }
}
