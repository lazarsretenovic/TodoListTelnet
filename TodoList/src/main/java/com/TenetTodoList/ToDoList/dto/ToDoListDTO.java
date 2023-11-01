package com.TenetTodoList.ToDoList.dto;

import com.TenetTodoList.ToDoList.domain.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ToDoListDTO(
        Integer id,
        @NotEmpty(message = "Add description for your to do list task:")
        @NotNull(message = "Status can`t be empty, chose one: COMPLETED,NOT_COMPLETED, IN_PROGRESS")
        String description,
        @NotNull(message = "Status can`t be empty, chose one: COMPLETED,NOT_COMPLETED, IN_PROGRESS")
        Status status,
        UserDTOBaseInfo user
)
{
}