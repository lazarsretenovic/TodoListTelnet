package com.TenetTodoList.TodoList.services;

import com.TenetTodoList.TodoList.domain.User;
import com.TenetTodoList.TodoList.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@Component
public class UserDTOMapperReverse implements Function <UserDTO, User>{

    public User apply(UserDTO userDTO){
        return new User(
                userDTO.id(),
                userDTO.username(),
                userDTO.password(),
                userDTO.user_detail()
        );
    }
}
