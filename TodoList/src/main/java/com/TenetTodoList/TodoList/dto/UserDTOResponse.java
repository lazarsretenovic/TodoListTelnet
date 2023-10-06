package com.TenetTodoList.TodoList.dto;

public record UserDTOResponse(
        int id,
        String username,
        UserDetailDTOResponse details
) {

}
