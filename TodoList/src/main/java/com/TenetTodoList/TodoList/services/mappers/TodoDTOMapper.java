package com.TenetTodoList.TodoList.services.mappers;

import com.TenetTodoList.TodoList.domain.TodoList;
import com.TenetTodoList.TodoList.dto.TodoListDTO;
import com.TenetTodoList.TodoList.dto.UserDTONoDetails;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@Component
public class TodoDTOMapper implements Function<TodoList, TodoListDTO> {

    private final UserDTONoDetailsMapper userDTOMapper;

    public TodoDTOMapper(UserDTONoDetailsMapper userDTOMapper) {
        this.userDTOMapper = userDTOMapper;
    }

    @Override
    public TodoListDTO apply(TodoList todoList){
        return new TodoListDTO(
                todoList.getId(),
                todoList.getDescription(),
                todoList.getStatus(),
                userDTOMapper.apply(todoList.getUser())
        );
    }

}