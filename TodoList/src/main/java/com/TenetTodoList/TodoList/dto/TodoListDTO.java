package com.TenetTodoList.TodoList.dto;

public record TodoListDTO(
        Integer id,
        String description,
        String status,
        UserDTO user
)
{
}