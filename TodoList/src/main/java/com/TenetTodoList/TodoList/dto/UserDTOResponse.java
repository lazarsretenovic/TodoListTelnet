package com.TenetTodoList.TodoList.dto;

public record UserDTOResponse(
        Integer id,
        String login_name,
        UserDetailDTOResponse details
) {
}
