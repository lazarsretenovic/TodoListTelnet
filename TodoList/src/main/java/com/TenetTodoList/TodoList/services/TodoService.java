package com.TenetTodoList.TodoList.services;

import com.TenetTodoList.TodoList.domain.TodoList;
import com.TenetTodoList.TodoList.dto.TodoListDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TodoService {
    List<TodoListDTO> findAll();

    TodoListDTO findById(int theId);

    TodoListDTO save(TodoListDTO todoList);

    void deleteById(int theId);

}
