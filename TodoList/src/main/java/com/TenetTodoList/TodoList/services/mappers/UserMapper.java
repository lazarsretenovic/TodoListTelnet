package com.TenetTodoList.TodoList.services.mappers;

import com.TenetTodoList.TodoList.domain.User;
import com.TenetTodoList.TodoList.dto.*;
import com.TenetTodoList.TodoList.services.mappers.request.TodoListRequestMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper implements UserConverter {
    private final com.TenetTodoList.TodoList.services.mappers.UserDetailsConverter userDetailsConverter;
    private final TodoListRequestMapper todoListRequestMapper;
    private static final Logger logger = LoggerFactory.getLogger(UserMapper.class);

    public UserMapper(UserDetailsConverter userDetailsConverter, TodoListRequestMapper todoListRequestMapper) {
        this.userDetailsConverter = userDetailsConverter;
        this.todoListRequestMapper = todoListRequestMapper;
    }
    @Override
    public User convertFromDTO(UserDTO dto) {
        try {
            User user = new User();
            user.setId(dto.id());
            user.setLoginname(dto.login_name());
            user.setRole(dto.role());
            UserDetailDto userDetailDto = dto.user_detail();
            user.setUserDetail(userDetailsConverter.convertFromDTO(userDetailDto));
            return user;
        } catch (Exception e) {
            logger.error("Error converting UserDTO to User", e);
            return null;
        }
    }

    @Override
    public UserDTO convertFromEntity(User entity) {
        try {
            UserDTO userDTO = new UserDTO(
                    entity.getId(),
                    entity.getLoginname(entity.getUsername()),
                    entity.getRole(),
                    userDetailsConverter.convertFromEntity(entity.getUserDetail())
            );
            UserDetailDto userDetailDto = userDetailsConverter.convertFromEntity(entity.getUserDetail());
            return userDTO;
        } catch (Exception e) {
            logger.error("Error converting User to UserDTO", e);
            return null;
        }
    }

    @Override
    public UserDTONoDetails convertFromEntityNoDetails(User entity) {
        try {
            UserDTONoDetails userDTONoDetails = new UserDTONoDetails(
                    entity.getId()
            );
            return userDTONoDetails;
        } catch (Exception e) {
            logger.error("Error converting User to UserDTONoDetails", e);
            return null;
        }
    }

    @Override
    public UserDTORequest convertFromEntityRequest(User entity) {
        try {
            List<TodoListDTORequest> todoListDTOs = entity.getTodoList().stream()
                    .map(todoListRequestMapper::apply)
                    .collect(Collectors.toList());

            return new UserDTORequest(
                    entity.getId(),
                    entity.getUsername(),
                    userDetailsConverter.convertFromEntityRequest(entity.getUserDetail()),
                    todoListDTOs
            );
        } catch (Exception e) {
            logger.error("Error converting User to UserDTORequest", e);
            return null;
        }
    }

    @Override
    public UserDTOResponse convertFromEntityResponse(User entity) {
        try {
            return new UserDTOResponse(
                    entity.getId(),
                    entity.getUsername(),
                    userDetailsConverter.convertFromEntityResponse(entity.getUserDetail())
            );
        } catch (Exception e) {
            logger.error("Error converting User to UserDTOResponse", e);
            return null;
        }
    }

    @Override
    public UserDTOWhoAmI convertFromEntityWhoAmI(User entity) {
        try {
            UserDTOWhoAmI userDtoWhoAmI = new UserDTOWhoAmI(
                    entity.getId(),
                    entity.getUsername(),
                    userDetailsConverter.convertFromEntity(entity.getUserDetail()),
                    entity.getRole(),
                    entity.isAccountNonExpired(),
                    entity.isAccountNonLocked(),
                    entity.isCredentialsNonExpired(),
                    entity.isEnabled()
            );
            return userDtoWhoAmI;
        } catch (Exception e) {
            logger.error("Error converting User to UserDTOWhoAmI", e);
            return null;
        }
    }
}