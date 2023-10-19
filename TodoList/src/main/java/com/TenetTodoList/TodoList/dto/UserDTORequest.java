package com.TenetTodoList.TodoList.dto;

import java.util.List;

public record UserDTORequest(
        Integer id,
        String username,
        String password,
        UserDetailDTORequest details,
        List<TodoListDTORequest> todos
) {

}
