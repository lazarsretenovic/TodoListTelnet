package com.TenetTodoList.TodoList.services.bcrypt;

import com.TenetTodoList.TodoList.domain.User;
import com.TenetTodoList.TodoList.dto.UserDTO;
import com.TenetTodoList.TodoList.dto.dtobcrytpt.UserDTOBcrypt;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserDTOBcryptMapper implements Function<User, UserDTOBcrypt> {

    @Override
    public UserDTOBcrypt apply(User user) {
        return new UserDTOBcrypt(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getUserDetail()
        );
    }
}
