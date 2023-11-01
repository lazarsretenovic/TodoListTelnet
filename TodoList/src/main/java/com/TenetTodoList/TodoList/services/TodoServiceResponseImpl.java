package com.TenetTodoList.TodoList.services;

import com.TenetTodoList.TodoList.dao.TodoRepository;
import com.TenetTodoList.TodoList.dto.TodoListDTOResponse;
import com.TenetTodoList.TodoList.exceptions.ResourceNotFoundException;
import com.TenetTodoList.TodoList.services.mappers.TodoListConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class TodoServiceResponseImpl implements TodoServiceResponse {
 private final TodoRepository todoRepository;
 private final TodoListConverter todoListConverter;

    public TodoServiceResponseImpl(TodoRepository todoRepository, TodoListConverter todoListConverter) {
        this.todoRepository = todoRepository;
        this.todoListConverter = todoListConverter;
    }
    @Override
    public List<TodoListDTOResponse> findAll() {
        try {
            return todoRepository.findAll()
                    .stream()
                    .map(todoListConverter::convertFromEntityResponse)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error while fetching response todo_List", e);
        }
    }
}