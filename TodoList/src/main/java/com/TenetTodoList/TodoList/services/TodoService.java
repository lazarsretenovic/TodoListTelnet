package com.TenetTodoList.TodoList.services;

import com.TenetTodoList.TodoList.domain.TodoList;
import com.TenetTodoList.TodoList.dto.TodoListDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TodoService {
    List<TodoListDTO> findAll();

    TodoListDTO findById(int theId);
    TodoListDTO savenew(TodoListDTO todoList);
    TodoListDTO save(TodoListDTO todoList);
    void deleteById(int theId);

}
