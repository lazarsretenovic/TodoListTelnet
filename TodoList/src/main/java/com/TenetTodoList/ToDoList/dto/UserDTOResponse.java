package com.TenetTodoList.ToDoList.dto;

public record UserDTOResponse(
        Integer id,
        String login_name,
        UserDetailDTOResponse details
) {
}
