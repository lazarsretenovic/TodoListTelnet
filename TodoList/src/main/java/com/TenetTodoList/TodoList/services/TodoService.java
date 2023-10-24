package com.TenetTodoList.TodoList.services;

import com.TenetTodoList.TodoList.dto.TodoListDTO;

import java.util.List;

public interface TodoService {
    List<TodoListDTO> findAll();

    TodoListDTO findById(Integer theId);
    TodoListDTO save_new(TodoListDTO todoList);
    TodoListDTO save(TodoListDTO todoList);
    void deleteById(Integer theId);

}
