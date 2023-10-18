package com.TenetTodoList.TodoList.dto;
import com.TenetTodoList.TodoList.domain.Role;

public record UserDTO (
        int id,
        String login_name,
        String password,
        Role role,
        UserDetailDto user_detail

) {


}

