package com.TenetTodoList.TodoList.services;

import com.TenetTodoList.TodoList.domain.TodoList;
import com.TenetTodoList.TodoList.dto.TodoListDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@Component
public class TodoDTOMapper implements Function<TodoList, TodoListDTO> {
    public TodoListDTO apply(TodoList todoList){
        return new TodoListDTO(
                todoList.getId(),
                todoList.getDescription(),
                todoList.getStatus(),
                todoList.getUser()
        );
    }

}
