package com.TenetTodoList.TodoList.services;

import com.TenetTodoList.TodoList.dao.TodoRepository;
import com.TenetTodoList.TodoList.dao.UserRepository;
import com.TenetTodoList.TodoList.domain.TodoList;
import com.TenetTodoList.TodoList.domain.User;
import com.TenetTodoList.TodoList.dto.TodoListDTO;
import com.TenetTodoList.TodoList.exceptions.ResourceNotFoundException;
import com.TenetTodoList.TodoList.services.mappers.TodoListConverter;
import com.TenetTodoList.TodoList.services.mappers.TodoListMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;
    private final UserRepository userRepository;
    private final TodoListConverter todoListConverter;
    public TodoServiceImpl(TodoRepository todoRepository, UserRepository userRepository, TodoListMapper todoListMapper, TodoListConverter todoListConverter) {
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;
        this.todoListConverter = todoListConverter;
    }
    @Override
    public List<TodoListDTO> findAll() {
        try {
            return todoRepository.findAll()
                    .stream()
                    .map(todoListConverter::convertFromEntity)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error while fetching todo_List", e);
        }
    }
    @Override
    public TodoListDTO findById(Integer theId) {
        Optional<TodoList> result = todoRepository.findById(theId);
        if (result.isPresent()) {
            TodoList todoList = result.get();
            return todoListConverter.convertFromEntity(todoList);
        } else {
            throw new ResourceNotFoundException("Did not find todo_List entry by the id of " + theId);
        }
    }
    @Override
    public TodoListDTO save_new(TodoListDTO todoListDTO) {
        try {
            TodoList todoList = todoListConverter.convertFromDTO(todoListDTO);
            User user = userRepository.findById(todoListDTO.user().id())
                    .orElseThrow(() -> new ResourceNotFoundException("User with ID " + todoListDTO.user().id() + " not found"));
            todoList.setUser(user);
            TodoList savedTodoList = todoRepository.save(todoList);
            return todoListConverter.convertFromEntity(savedTodoList);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error with adding new todo_List", e);
        }
    }
    @Override
    public TodoListDTO save(TodoListDTO todoListDTO) {
        try {
            Optional<TodoList> existingTodo = todoRepository.findById(todoListDTO.id());
            if (existingTodo.isPresent()) {
                TodoList todoToUpdate = existingTodo.get();
                todoToUpdate.setDescription(todoListDTO.description());
                todoToUpdate.setStatus(todoListDTO.status());
                return todoListConverter.convertFromEntity(todoRepository.save(todoToUpdate));
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
