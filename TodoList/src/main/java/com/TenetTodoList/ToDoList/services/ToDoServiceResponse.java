package com.TenetTodoList.ToDoList.services;

import com.TenetTodoList.ToDoList.dto.ToDoListDTOResponse;

import java.util.List;

public interface ToDoServiceResponse {
    List<ToDoListDTOResponse> findAll();
}
