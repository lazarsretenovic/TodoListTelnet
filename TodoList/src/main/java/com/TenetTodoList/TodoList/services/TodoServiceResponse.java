package com.TenetTodoList.TodoList.services;

import com.TenetTodoList.TodoList.dto.TodoListDTOResponse;

import java.util.List;

public interface TodoServiceResponse {
    List<TodoListDTOResponse> findAll();
}
