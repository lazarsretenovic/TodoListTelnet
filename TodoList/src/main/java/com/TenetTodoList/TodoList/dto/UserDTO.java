package com.TenetTodoList.TodoList.dto;

import com.TenetTodoList.TodoList.domain.UserDetail;

public record UserDTO (
        int id,
        String login_name,
        String password,
        UserDetailDto user_detail

) {


}

