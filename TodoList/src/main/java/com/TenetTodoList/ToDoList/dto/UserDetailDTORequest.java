package com.TenetTodoList.ToDoList.dto;

public record UserDetailDTORequest(
         Integer id,
         String first_name,
         String last_name,
         String email,
         String city
) {
}
