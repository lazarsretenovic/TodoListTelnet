package com.TenetTodoList.TodoList.services.mappers;

import com.TenetTodoList.TodoList.domain.TodoList;
import com.TenetTodoList.TodoList.dto.TodoListDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@Component
public class TodoDTOMapper implements Function<TodoList, TodoListDTO> {

    private final UserDTOMapper userDTOMapper;

    public TodoDTOMapper(UserDTOMapper userDTOMapper) {
        this.userDTOMapper = userDTOMapper;
    }

    public TodoListDTO apply(TodoList todoList){
        return new TodoListDTO(
                todoList.getId(),
                todoList.getDescription(),
                todoList.getStatus(),
                userDTOMapper.apply(todoList.getUser())
        );
    }

}
