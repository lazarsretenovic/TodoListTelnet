package com.TenetTodoList.TodoList.dto;

public record TodoListDTOResponse(
        String Description,
        String Status,
        UserDTO userDTOResponse
) {
}
