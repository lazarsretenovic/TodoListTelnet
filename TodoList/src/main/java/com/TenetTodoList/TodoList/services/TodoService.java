package com.TenetTodoList.TodoList.services;

import com.TenetTodoList.TodoList.domain.Todo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TodoService {
    List<Todo> findAll();

    Todo findById(int theId);

    Todo save(Todo todo);

    void deleteById(int theId);
}
