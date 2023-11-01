package com.TenetTodoList.ToDoList.services;

import com.TenetTodoList.ToDoList.dao.ToDoRepository;
import com.TenetTodoList.ToDoList.dao.UserRepository;
import com.TenetTodoList.ToDoList.domain.ToDoList;
import com.TenetTodoList.ToDoList.domain.User;
import com.TenetTodoList.ToDoList.dto.ToDoListDTO;
import com.TenetTodoList.ToDoList.exceptions.ResourceNotFoundException;
import com.TenetTodoList.ToDoList.services.mappers.ToDoMapper;
import com.TenetTodoList.ToDoList.services.mappers.ToDoMapperImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ToDoServiceImpl implements ToDoService {
    private final ToDoRepository todoRepository;
    private final UserRepository userRepository;
    private final ToDoMapper todoMapper;
    public ToDoServiceImpl(ToDoRepository todoRepository, UserRepository userRepository, ToDoMapperImpl todoListMapperImpl, ToDoMapper todoMapper) {
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;
        this.todoMapper = todoMapper;
    }
    @Override
    public List<ToDoListDTO> findAll() {
        try {
            return todoRepository.findAll()
                    .stream()
                    .map(todoMapper::TodoListFromEntityToDto)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error while fetching todo_List", e);
        }
    }
    @Override
    public ToDoListDTO findById(Integer theId) {
        Optional<ToDoList> result = todoRepository.findById(theId);
        if (result.isPresent()) {
            ToDoList todoList = result.get();
            return todoMapper.TodoListFromEntityToDto(todoList);
        } else {
            throw new ResourceNotFoundException("Did not find todo_List entry by the id of " + theId);
        }
    }
    @Override
    public ToDoListDTO save_new(ToDoListDTO todoListDTO) {
        try {
            ToDoList todoList = todoMapper.TodoListFromDtoToEntity(todoListDTO);
            User user = userRepository.findById(todoListDTO.user().id())
                    .orElseThrow(() -> new ResourceNotFoundException("User with ID " + todoListDTO.user().id() + " not found"));
            todoList.setUser(user);
            ToDoList savedToDoList = todoRepository.save(todoList);
            return todoMapper.TodoListFromEntityToDto(savedToDoList);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error with adding new todo_List", e);
        }
    }
    @Override
    public ToDoListDTO save(ToDoListDTO todoListDTO) {
        try {
            Optional<ToDoList> existingTodo = todoRepository.findById(todoListDTO.id());
            if (existingTodo.isPresent()) {
                ToDoList todoToUpdate = existingTodo.get();
                todoToUpdate.setDescription(todoListDTO.description());
                todoToUpdate.setStatus(todoListDTO.status());
                return todoMapper.TodoListFromEntityToDto(todoRepository.save(todoToUpdate));
            } else {
                throw new ResourceNotFoundException("TodoList with ID " + todoListDTO.id() + " not found for update");
            }
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error while updating todo_List with ID " + todoListDTO.id(), e);
        }
    }
    @Override
    public void deleteById(Integer theId) {
        try {
            todoRepository.deleteById(theId);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error while deleting todo_List entry with ID " + theId, e);
        }
    }


}
