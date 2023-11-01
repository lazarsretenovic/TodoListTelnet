package com.TenetTodoList.ToDoList.dto;

import com.TenetTodoList.ToDoList.domain.Status;

public record ToDoListDTORequest(
        Integer id,
        String description,
        Status status

) {
}
