package com.TenetTodoList.TodoList.services.mappers;

import com.TenetTodoList.TodoList.domain.User;
import com.TenetTodoList.TodoList.domain.UserDetail;
import com.TenetTodoList.TodoList.dto.UserDTO;
import com.TenetTodoList.TodoList.dto.UserDetailDto;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserDTOMapperReverse implements Function<UserDTO, User> {
    public User apply(UserDTO userDTO) {
        UserDetailDto userDetailDto = userDTO.user_detail();
        UserDetail userDetail = new UserDetail(
                userDetailDto.id(),
                userDetailDto.firstName(),
                userDetailDto.lastName(),
                userDetailDto.email(),
                userDetailDto.city()
        );

        return new User(
                userDTO.id(),
                userDTO.username(),
                userDTO.password(),
                userDetail
        );
    }
}
