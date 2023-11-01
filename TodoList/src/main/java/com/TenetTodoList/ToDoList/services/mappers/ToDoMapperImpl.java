package com.TenetTodoList.ToDoList.services.mappers;

import com.TenetTodoList.ToDoList.domain.ToDoList;
import com.TenetTodoList.ToDoList.dto.ToDoListDTO;
import com.TenetTodoList.ToDoList.dto.ToDoListDTORequest;
import com.TenetTodoList.ToDoList.dto.ToDoListDTOResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Component
public class ToDoMapperImpl implements ToDoMapper {
    private final UserMapper userMapper;
    private static final Logger logger = LoggerFactory.getLogger(ToDoMapperImpl.class);
    public ToDoMapperImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    @Override
    public ToDoList TodoListFromDtoToEntity(ToDoListDTO dto) {
        try {
            ToDoList todoList = new ToDoList();
            todoList.setId(dto.id());
            todoList.setDescription(dto.description());
            todoList.setStatus(dto.status());
            return todoList;
        } catch (Exception e) {
            logger.error("Error converting TodoListDTO to TodoList", e);
            throw new RuntimeException("Error with converting", e);
        }
    }
    @Override
    public ToDoListDTO TodoListFromEntityToDto(ToDoList entity) {
        try {
            return new ToDoListDTO(
                    entity.getId(),
                    entity.getDescription(),
                    entity.getStatus(),
                    userMapper.convertFromEntityBaseInfo(entity.getUser())
            );
        } catch (Exception e) {
            logger.error("Error converting TodoList to TodoListDTO", e);
            throw new RuntimeException("Error with converting", e);
        }
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
}
