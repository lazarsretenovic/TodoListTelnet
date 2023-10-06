package com.TenetTodoList.TodoList.services.mappers;

import com.TenetTodoList.TodoList.domain.User;
import com.TenetTodoList.TodoList.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@Component
public class UserDTOMapper implements Function<User, UserDTO> {


    public UserDTO apply(User user){
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getUserDetail()

        );
    }
}
