package com.TenetTodoList.TodoList.dto;

public record TodoListDTO(
         int id,
         String description,
         String status,
         UserDTO user
)
{
}
