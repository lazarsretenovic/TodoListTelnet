package com.TenetTodoList.ToDoList.dto;
import com.TenetTodoList.ToDoList.domain.Role;
import jakarta.validation.constraints.NotNull;

public record UserDTO (
        Integer id,
        @NotNull(message = "Invalid Login name: field cant be empty")
        String login_name,
        Role role,
        UserDetailDto user_detail

) {

}

