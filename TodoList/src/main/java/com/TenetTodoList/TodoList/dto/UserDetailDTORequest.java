package com.TenetTodoList.TodoList.dto;

import jakarta.persistence.Column;

public record UserDetailDTORequest(
         Integer id,
         String first_name,
         String last_name,
         String email,
         String city
) {
}
