package com.TenetTodoList.TodoList.dto;

import com.TenetTodoList.TodoList.domain.Status;

public record TodoListDTO(
        Integer id,
        String description,
        Status status,
        UserDTONoDetails user
)
{
}