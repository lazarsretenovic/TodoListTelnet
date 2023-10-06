package com.TenetTodoList.TodoList.services.mappers;

import com.TenetTodoList.TodoList.domain.TodoList;
import com.TenetTodoList.TodoList.dto.TodoListDTOResponse;
import com.TenetTodoList.TodoList.services.mappers.UserDTOMapperResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TodoListDTOMapperResponse implements Function<TodoList, TodoListDTOResponse> {

    private final UserDTOMapperResponse userDTOMapperResponse;

    public TodoListDTOMapperResponse(UserDTOMapperResponse userDTOMapperResponse) {
        this.userDTOMapperResponse = userDTOMapperResponse;
    }


    public TodoListDTOResponse apply(TodoList todoList){
        return new TodoListDTOResponse(
                todoList.getId(),
                todoList.getDescription(),
                todoList.getStatus(),
                userDTOMapperResponse.apply(todoList.getUser())
        );
    }

}
