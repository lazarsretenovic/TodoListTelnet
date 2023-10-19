package com.TenetTodoList.TodoList.dto;

public record TodoListDTOResponse(
        Integer id,
        String description,
        String status,
        UserDTOResponse user
) {
}
