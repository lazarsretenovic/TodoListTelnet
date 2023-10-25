package com.TenetTodoList.TodoList.services.mappers;

import com.TenetTodoList.TodoList.domain.User;
import com.TenetTodoList.TodoList.dto.UserDtoWho;

import java.util.function.Function;

public class UserDtoWhoMapper implements Function<User, UserDtoWho> {
    private final UserDetailDTOMapper userDetailDTOMapper;

    public UserDtoWhoMapper(UserDetailDTOMapper userDetailDTOMapper) {
        this.userDetailDTOMapper = userDetailDTOMapper;
    }

    @Override
    public UserDtoWho apply(User user) {
        UserDtoWho userDtoWho = new UserDtoWho(
                user.getId(),
                user.getUsername(), // Use the correct property for the username
                userDetailDTOMapper.apply(user.getUserDetail()),
                user.getRole(),
                user.isAccountNonExpired(),
                user.isAccountNonLocked(),
                user.isCredentialsNonExpired(),
                user.isEnabled()
        );
        return userDtoWho;
    }
}
