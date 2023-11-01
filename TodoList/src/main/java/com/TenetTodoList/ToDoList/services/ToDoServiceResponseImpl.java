package com.TenetTodoList.ToDoList.services;

import com.TenetTodoList.ToDoList.dao.ToDoRepository;
import com.TenetTodoList.ToDoList.dto.ToDoListDTOResponse;
import com.TenetTodoList.ToDoList.exceptions.ResourceNotFoundException;
import com.TenetTodoList.ToDoList.services.mappers.ToDoMapper;
import com.TenetTodoList.ToDoList.services.mappers.UserToDoListMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ToDoServiceResponseImpl implements ToDoServiceResponse {
 private final ToDoRepository todoRepository;
 private final UserToDoListMapper userToDoListMapper;

    public ToDoServiceResponseImpl(ToDoRepository todoRepository, UserToDoListMapper userToDoListMapper) {
        this.todoRepository = todoRepository;
        this.userToDoListMapper = userToDoListMapper;
    }

    @Override
    public List<ToDoListDTOResponse> findAll() {
        try {
            return todoRepository.findAll()
                    .stream()
                    .map(userToDoListMapper::TodoListResponseFromEntityToDto)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error while fetching response todo_List", e);
        }
    }
}