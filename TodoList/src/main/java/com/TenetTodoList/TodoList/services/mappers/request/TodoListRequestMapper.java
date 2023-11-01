package com.TenetTodoList.TodoList.services.mappers.request;

import com.TenetTodoList.TodoList.domain.TodoList;
import com.TenetTodoList.TodoList.dto.TodoListDTORequest;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TodoListRequestMapper implements Function<TodoList, TodoListDTORequest> {

    public TodoListDTORequest apply(TodoList todoList){
        return new TodoListDTORequest(
                todoList.getId(),
                todoList.getDescription(),
                todoList.getStatus()
        );
    }

}
