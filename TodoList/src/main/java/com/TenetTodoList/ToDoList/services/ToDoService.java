package com.TenetTodoList.ToDoList.services;

import com.TenetTodoList.ToDoList.dto.ToDoListDTO;

import java.util.List;

public interface ToDoService {
    List<ToDoListDTO> findAll();

    ToDoListDTO findById(Integer theId);
    ToDoListDTO save_new(ToDoListDTO todoList);
    ToDoListDTO save(ToDoListDTO todoList);
    void deleteById(Integer theId);

}
