package com.TenetTodoList.ToDoList.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record UserDetailDto(
        Integer id,
        @NotNull(message = "Invalid Name: field cant be empty")
        String first_name,
        @NotNull(message = "Invalid Last Name: field cant be empty")
        String last_name,
        @Email(message = "Invalid Email")
        @NotNull(message = "Invalid Email, field cant be empty")
        String email,
        String city
) {

}
