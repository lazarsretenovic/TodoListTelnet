package com.TenetTodoList.TodoList.dto;

import com.TenetTodoList.TodoList.domain.Status;

public record TodoListDTORequest(
        Integer id,
        String description,
        Status status

) {
}
