package com.TenetTodoList.TodoList.dto;

import java.util.List;

public record UserDTORequest(
        int id,
        String username,
        String password,
        UserDetailDTORequest detail,
        List<TodoListDTORequest> todos
) {

}
