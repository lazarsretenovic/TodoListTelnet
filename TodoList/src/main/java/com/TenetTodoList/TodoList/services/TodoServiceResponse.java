package com.TenetTodoList.TodoList.services;

import com.TenetTodoList.TodoList.dto.TodoListDTO;
import com.TenetTodoList.TodoList.dto.TodoListDTOResponse;
import com.TenetTodoList.TodoList.services.mappers.TodoListDTOMapperResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TodoServiceResponse {
    List<TodoListDTOResponse> findAll();
}
