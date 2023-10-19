package com.TenetTodoList.TodoList.services;

import com.TenetTodoList.TodoList.dao.TodoRepository;
import com.TenetTodoList.TodoList.domain.TodoList;
import com.TenetTodoList.TodoList.dto.TodoListDTOResponse;
import com.TenetTodoList.TodoList.exceptions.ResourceNotFoundException;
import com.TenetTodoList.TodoList.services.mappers.TodoListDTOMapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class TodoServiceResponseImpl implements TodoServiceResponse {
    private final TodoRepository todoRepository;
    @Autowired
    private TodoListDTOMapperResponse todoListDTOMapperResponse;

    public TodoServiceResponseImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<TodoListDTOResponse> findAll() {
        try {
            return todoRepository.findAll()
                    .stream()
                    .map(todoListDTOMapperResponse::apply)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error while fetching response todo_List", e);
        }
    }

}