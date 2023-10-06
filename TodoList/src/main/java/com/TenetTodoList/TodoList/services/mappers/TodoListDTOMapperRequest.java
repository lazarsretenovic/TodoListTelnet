package com.TenetTodoList.TodoList.services.mappers;

import com.TenetTodoList.TodoList.domain.TodoList;
import com.TenetTodoList.TodoList.dto.TodoListDTORequest;
import com.TenetTodoList.TodoList.dto.TodoListDTOResponse;
import com.TenetTodoList.TodoList.services.mappers.UserDTOMapperResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TodoListDTOMapperRequest implements Function<TodoList, TodoListDTORequest> {

    private final UserDTOMapperRequest userDTOMapperRequest;

    public TodoListDTOMapperRequest(UserDTOMapperRequest userDTOMapperRequest) {
        this.userDTOMapperRequest = userDTOMapperRequest;
    }

    public TodoListDTORequest apply(TodoList todoList){
        return new TodoListDTORequest(
                todoList.getId(),
                todoList.getDescription(),
                todoList.getStatus(),
                userDTOMapperRequest.apply(todoList.getUser())
        );
    }

}
