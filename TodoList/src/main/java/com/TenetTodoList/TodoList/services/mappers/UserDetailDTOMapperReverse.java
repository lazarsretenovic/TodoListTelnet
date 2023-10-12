package com.TenetTodoList.TodoList.services.mappers;

import com.TenetTodoList.TodoList.domain.UserDetail;
import com.TenetTodoList.TodoList.dto.UserDTO;
import com.TenetTodoList.TodoList.dto.UserDetailDto;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserDetailDTOMapperReverse implements Function<UserDTO, UserDetail> {
    @Override
    public UserDetail apply(UserDTO userDTO) {
        UserDetailDto userDetailDto = userDTO.user_detail();  // Correct the field name here
        UserDetail userDetail = new UserDetail(
                userDetailDto.id(),
                userDetailDto.firstName(),
                userDetailDto.lastName(),
                userDetailDto.email(),
                userDetailDto.city()
        );

        return userDetail;
    }
}
