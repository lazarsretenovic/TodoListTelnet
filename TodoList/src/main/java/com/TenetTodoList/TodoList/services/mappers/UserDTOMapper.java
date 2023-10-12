package com.TenetTodoList.TodoList.services.mappers;

import com.TenetTodoList.TodoList.domain.UserTodos;
import com.TenetTodoList.TodoList.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserDTOMapper implements Function<UserTodos, UserDTO> {
    private final UserDetailDTOMapper userDetailDTOMapper;

    public UserDTOMapper(UserDetailDTOMapper userDetailDTOMapper) {
        this.userDetailDTOMapper = userDetailDTOMapper;
    }

    public UserDTO apply(UserTodos userTodos) {
        UserDTO userDTO = new UserDTO(
                userTodos.getId(),
                userTodos.getUsername(),
                userTodos.getPassword(),
                userDetailDTOMapper.apply(userTodos.getUserDetail())
        );
        return userDTO;
    }
}
