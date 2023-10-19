package com.TenetTodoList.TodoList.dto;

import java.util.List;

public record UserDTORequest(
        Integer id,
        String login_name,
        UserDetailDTORequest details,
        List<TodoListDTORequest> todos
) {

}
