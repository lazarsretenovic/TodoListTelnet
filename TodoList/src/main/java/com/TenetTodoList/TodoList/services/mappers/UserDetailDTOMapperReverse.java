package com.TenetTodoList.TodoList.services.mappers;

import com.TenetTodoList.TodoList.domain.UserDetail;
import com.TenetTodoList.TodoList.dto.UserDetailDto;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserDetailDTOMapperReverse implements Function<UserDetailDto, UserDetail> {
    public UserDetail apply(UserDetailDto userDetailDto){
        return new UserDetail(
                userDetailDto.id(),
                userDetailDto.firstName(),
                userDetailDto.lastName(),
                userDetailDto.city(),
                userDetailDto.email()
        );
    }
}
