package com.TenetTodoList.TodoList.dto;

import com.TenetTodoList.TodoList.domain.UserDetail;

public record UserDTO (
        int id,
        String username,
        String password,
        UserDetail user_detail

) {


}

