package com.TenetTodoList.TodoList.services.mappers;

import com.TenetTodoList.TodoList.domain.UserDetail;
import com.TenetTodoList.TodoList.dto.UserDTO;
import com.TenetTodoList.TodoList.dto.UserDetailDto;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserDetailDTOMapperReverse implements Function<UserDetailDto, UserDetail> {
    @Override
    public UserDetail apply(UserDetailDto userDetailDto) {
        return new UserDetail(
                userDetailDto.id(),
                userDetailDto.first_name(),
                userDetailDto.last_name(),
                userDetailDto.email(),
                userDetailDto.city()
        );

    }
}
