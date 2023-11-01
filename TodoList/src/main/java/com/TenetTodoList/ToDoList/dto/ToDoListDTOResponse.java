package com.TenetTodoList.ToDoList.dto;

import com.TenetTodoList.ToDoList.domain.Status;

public record ToDoListDTOResponse(
        Integer id,
        String description,
        Status status,
        UserDTOResponse user
) {
}
