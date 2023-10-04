package com.TenetTodoList.TodoList.services;

import com.TenetTodoList.TodoList.Dao.TodoRepository;
import com.TenetTodoList.TodoList.domain.TodoList;
import com.TenetTodoList.TodoList.dto.TodoListDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService {
    private TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<TodoListDTO> findAll() {
        return  todoRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public TodoListDTO findById(int theId) {
        Optional<TodoList> result = todoRepository.findById(theId);
        if (result.isPresent()) {
            TodoList todoList = result.get();
            return convertEntityToDto(todoList); // Convert the entity to DTO
        } else {
            throw new RuntimeException("Did not find Todo with the id of " + theId);
        }
    }

    @Override
    public TodoListDTO save(TodoListDTO todoListDTO) {
        TodoList todoList = convertDtoToEntity(todoListDTO);
        return convertEntityToDto(todoRepository.save(todoList));
    }

    @Override
    public void deleteById(int theId) {
        todoRepository.deleteById(theId);
    }

    private TodoListDTO convertEntityToDto(TodoList todoList) {
        TodoListDTO todoListDTO = new TodoListDTO();
        todoListDTO.setId(todoList.getId());
        todoListDTO.setDescription(todoList.getDescription());
        todoListDTO.setStatus(todoList.getStatus());
        return todoListDTO;
    }

    private TodoList convertDtoToEntity(TodoListDTO todoListDTO) {
        TodoList todoList = new TodoList();
        todoList.setDescription(todoListDTO.getDescription());
        todoList.setStatus(todoListDTO.getStatus());
        return todoList;
    }
}
