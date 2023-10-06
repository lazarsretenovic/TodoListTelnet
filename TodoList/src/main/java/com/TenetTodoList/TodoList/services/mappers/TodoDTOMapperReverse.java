package com.TenetTodoList.TodoList.services.mappers;

import com.TenetTodoList.TodoList.domain.TodoList;
import com.TenetTodoList.TodoList.dto.TodoListDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TodoDTOMapperReverse implements Function<TodoListDTO, TodoList> {

    public TodoList apply(TodoListDTO todoListDTO){
        return new TodoList(
                todoListDTO.id(),
                todoListDTO.description(),
                todoListDTO.status(),
                todoListDTO.user()
        );
    }
}
