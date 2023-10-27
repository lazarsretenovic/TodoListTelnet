package com.TenetTodoList.TodoList.services.mappers;

import com.TenetTodoList.TodoList.domain.User;
import com.TenetTodoList.TodoList.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserDTOMapper implements Function<User, UserDTO> {
    private final UserDetailDTOMapper userDetailDTOMapper;

    public UserDTOMapper(UserDetailDTOMapper userDetailDTOMapper)
    {
        this.userDetailDTOMapper = userDetailDTOMapper;
    }

    public UserDTO apply(User user) {
        UserDTO userDTO = new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getRole(),
                userDetailDTOMapper.apply(user.getUserDetail())
        );
        return userDTO;
    }
}
