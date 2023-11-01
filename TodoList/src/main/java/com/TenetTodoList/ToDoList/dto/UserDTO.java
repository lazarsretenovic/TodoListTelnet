package com.TenetTodoList.ToDoList.dto;
import com.TenetTodoList.ToDoList.domain.Role;

public record UserDTO (
        Integer id,
        String login_name,
        Role role,
        UserDetailDto user_detail

) {

}

