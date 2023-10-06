package com.TenetTodoList.TodoList.dto;

public record TodoListDTOResponse(
        int id,
        String description,
        String status,
        UserDTOResponse user
) {
}
