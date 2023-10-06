package com.TenetTodoList.TodoList.services;

import com.TenetTodoList.TodoList.dao.TodoRepository;
import com.TenetTodoList.TodoList.domain.TodoList;
import com.TenetTodoList.TodoList.dto.TodoListDTOResponse;
import com.TenetTodoList.TodoList.exceptions.ResourceNotFoundException;
import com.TenetTodoList.TodoList.services.mappers.TodoListDTOMapperResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class TodoServiceResponseImpl implements TodoServiceResponse {
    private final TodoRepository todoRepository;
    private final TodoListDTOMapperResponse todoListDTOMapperResponse;

    public TodoServiceResponseImpl(TodoRepository todoRepository, TodoListDTOMapperResponse todoListDTOMapperResponse) {
        this.todoRepository = todoRepository;
        this.todoListDTOMapperResponse = todoListDTOMapperResponse;
    }

    @Override
    public List<TodoListDTOResponse> findAll() {
        return todoRepository.findAll()
                .stream()
                .map(todoListDTOMapperResponse::apply)
                .collect(Collectors.toList());

    }

//    @Override
//    public TodoListDTOResponse findById(int theId) {
//            TodoListDTOResponse todoListDTO = todoRepository.findById(theId)
//                    .orElseThrow(() -> new ResourceNotFoundException("Did not find Todo with the id of " + theId));
//
//            return todoListDTOMapperResponse.apply(todoListDTO);
//        }
//    }

}