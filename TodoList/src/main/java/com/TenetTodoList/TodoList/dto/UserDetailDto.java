package com.TenetTodoList.TodoList.dto;

public record UserDetailDto(
        Integer id,
        String first_name,
        String last_name,
        String email,
        String city
) {

}
