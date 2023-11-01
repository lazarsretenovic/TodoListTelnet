package com.TenetTodoList.TodoList.services.mappers;

import com.TenetTodoList.TodoList.domain.TodoList;
import com.TenetTodoList.TodoList.dto.TodoListDTO;
import com.TenetTodoList.TodoList.dto.TodoListDTORequest;
import com.TenetTodoList.TodoList.dto.TodoListDTOResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TodoListMapper implements TodoListConverter {
    private final UserConverter userConverter;
    private static final Logger logger = LoggerFactory.getLogger(TodoListMapper.class);
    public TodoListMapper(UserConverter userConverter) {
        this.userConverter = userConverter;
    }

    @Override
    public TodoList convertFromDTO(TodoListDTO dto) {
        try {
            TodoList todoList = new TodoList();
            todoList.setId(dto.id());
            todoList.setDescription(dto.description());
            todoList.setStatus(dto.status());
            return todoList;
        } catch (Exception e) {
            logger.error("Error converting TodoListDTO to TodoList", e);
            return null;
        }
    }
    @Override
    public TodoListDTO convertFromEntity(TodoList entity) {
        try {
            return new TodoListDTO(
                    entity.getId(),
                    entity.getDescription(),
                    entity.getStatus(),
                    userConverter.convertFromEntityNoDetails(entity.getUser())
            );
        } catch (Exception e) {
            logger.error("Error converting TodoList to TodoListDTO", e);
            return null;
        }
    }

    @Override
    public TodoListDTORequest convertFromEntityRequest(TodoList entity) {
        try {
            return new TodoListDTORequest(
                    entity.getId(),
                    entity.getDescription(),
                    entity.getStatus()
            );
        } catch (Exception e) {
            logger.error("Error converting TodoList to TodoListDTORequest", e);
            return null;
        }
    }

    @Override
    public TodoListDTOResponse convertFromEntityResponse(TodoList entity) {
        try {
            return new TodoListDTOResponse(
                    entity.getId(),
                    entity.getDescription(),
                    entity.getStatus(),
                    userConverter.convertFromEntityResponse(entity.getUser())
            );
        } catch (Exception e) {
            logger.error("Error converting TodoList to TodoListDTOResponse", e);
            return null;
        }
    }
}
