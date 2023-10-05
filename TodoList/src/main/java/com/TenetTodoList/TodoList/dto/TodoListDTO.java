package com.TenetTodoList.TodoList.dto;

import com.TenetTodoList.TodoList.domain.User;

public record TodoListDTO(
         int id,
         String description,
         String status,
         User user
)
{
}
