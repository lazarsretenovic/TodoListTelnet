package com.TenetTodoList.TodoList.services.mappers;

import com.TenetTodoList.TodoList.domain.User;
import com.TenetTodoList.TodoList.dto.UserDTOWhoAmI;

import java.util.function.Function;

public class UserDTOWhoAmIMapper implements Function<User, UserDTOWhoAmI> {
    private final UserDetailDTOMapper userDetailDTOMapper;

    public UserDTOWhoAmIMapper(UserDetailDTOMapper userDetailDTOMapper) {
        this.userDetailDTOMapper = userDetailDTOMapper;
    }

    @Override
    public UserDTOWhoAmI apply(User user) {
        UserDTOWhoAmI userDtoWhoAmI = new UserDTOWhoAmI(
                user.getId(),
                user.getUsername(), // Use the correct property for the username
                userDetailDTOMapper.apply(user.getUserDetail()),
                user.getRole(),
                user.isAccountNonExpired(),
                user.isAccountNonLocked(),
                user.isCredentialsNonExpired(),
                user.isEnabled()
        );
        return userDtoWhoAmI;
    }
}
