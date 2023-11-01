package com.TenetTodoList.ToDoList.dto;

import com.TenetTodoList.ToDoList.domain.Status;

public record ToDoListDTO(
        Integer id,
        String description,
        Status status,
        UserDTOBaseInfo user
)
{
}