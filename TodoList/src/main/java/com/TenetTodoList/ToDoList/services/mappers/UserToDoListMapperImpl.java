package com.TenetTodoList.ToDoList.services.mappers;

import com.TenetTodoList.ToDoList.domain.ToDoList;
import com.TenetTodoList.ToDoList.domain.User;
import com.TenetTodoList.ToDoList.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserToDoListMapperImpl implements UserToDoListMapper {
    private final ToDoMapper todoMapper;
    private final UserDetailsMapper userDetailsMapper;
    private final UserMapper userMapper;
    private static final Logger logger = LoggerFactory.getLogger(UserToDoListMapperImpl.class);

    public UserToDoListMapperImpl(ToDoMapper todoMapper, UserDetailsMapper userDetailsMapper, UserMapper userMapper) {
        this.todoMapper = todoMapper;
        this.userDetailsMapper = userDetailsMapper;
        this.userMapper = userMapper;
    }
    @Override
    public ToDoListDTORequest TodoListRequestFromEntityToDto(ToDoList entity) {
        try {
            return new ToDoListDTORequest(
                    entity.getId(),
                    entity.getDescription(),
                    entity.getStatus()
            );
        } catch (Exception e) {
            logger.error("Error converting TodoList to TodoListDTORequest", e);
            throw new RuntimeException("Error with converting", e);
        }
    }
    @Override
    public ToDoListDTOResponse TodoListResponseFromEntityToDto(ToDoList entity) {
        try {
            return new ToDoListDTOResponse(
                    entity.getId(),
                    entity.getDescription(),
                    entity.getStatus(),
                    userMapper.UserDTOResponseFromEntityToDto(entity.getUser())
            );
        } catch (Exception e) {
            logger.error("Error converting TodoList to TodoListDTOResponse", e);
            throw new RuntimeException("Error with converting", e);
        }
    }
    @Override
    public UserDTOBaseInfo UserBaseIfoEntityToDto(User entity) {
        try {
            UserDTOBaseInfo userDTOBaseInfo = new UserDTOBaseInfo(
                    entity.getId()
            );
            return userDTOBaseInfo;
        } catch (Exception e) {
            logger.error("Error converting User to UserDTONoDetails", e);
            throw new RuntimeException("Error with converting", e);
        }
    }
    @Override
    public UserDTORequest UserDTORequestFromEntityToDto(User entity) {
        try {
            List<ToDoListDTORequest> todoListDTOs = entity.getTodoList().stream()
                    .map(todoMapper::TodoListRequestFromEntityToDto)
                    .collect(Collectors.toList());
            return new UserDTORequest(
                    entity.getId(),
                    entity.getUsername(),
                    userDetailsMapper.UserDetailRequestFromEntityToDto(entity.getUserDetail()),
                    todoListDTOs
            );
        } catch (Exception e) {
            logger.error("Error converting User to UserDTORequest", e);
            throw new RuntimeException("Error with converting", e);
        }
    }
    @Override
    public UserDTOResponse UserDTOResponseFromEntityToDto(User entity) {
        try {
            return new UserDTOResponse(
                    entity.getId(),
                    entity.getUsername(),
                    userDetailsMapper.UserDetailResponseFromEntityToDto(entity.getUserDetail())
            );
        } catch (Exception e) {
            logger.error("Error converting User to UserDTOResponse", e);
            throw new RuntimeException("Error with converting", e);
        }
    }

}
