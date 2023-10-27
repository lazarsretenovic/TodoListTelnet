package com.TenetTodoList.TodoList.dto;

import com.TenetTodoList.TodoList.domain.Status;

public record TodoListDTOResponse(
        Integer id,
        String description,
        Status status,
        UserDTOResponse user
) {
}
