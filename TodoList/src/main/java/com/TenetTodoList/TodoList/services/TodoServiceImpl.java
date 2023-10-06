package com.TenetTodoList.TodoList.services;

import com.TenetTodoList.TodoList.dao.TodoRepository;
import com.TenetTodoList.TodoList.domain.TodoList;
import com.TenetTodoList.TodoList.dto.TodoListDTO;
import com.TenetTodoList.TodoList.exceptions.ResourceNotFoundException;
import com.TenetTodoList.TodoList.services.mappers.TodoDTOMapper;
import com.TenetTodoList.TodoList.services.mappers.TodoDTOMapperReverse;
import com.TenetTodoList.TodoList.services.mappers.UserDTOMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;
    private final TodoDTOMapper todoDTOMapper;
    private final TodoDTOMapperReverse todoDTOMapperReverse;
    private final UserDTOMapper userDTOMapper;

    public TodoServiceImpl(TodoRepository todoRepository, TodoDTOMapper todoDTOMapper, TodoDTOMapperReverse todoDTOMapperReverse, UserDTOMapper userDTOMapper) {
        this.todoRepository = todoRepository;
        this.todoDTOMapper = todoDTOMapper;
        this.todoDTOMapperReverse = todoDTOMapperReverse;
        this.userDTOMapper = userDTOMapper;
    }

    @Override
    public List<TodoListDTO> findAll() {
        return  todoRepository.findAll()
                .stream()
                .map(todoDTOMapper::apply)
                .collect(Collectors.toList());
    }

    @Override
    public TodoListDTO findById(int theId) {
        Optional<TodoList> result = todoRepository.findById(theId);
        if (result.isPresent()) {
            TodoList todoList = result.get();
            return todoDTOMapper.apply(todoList);
        } else {
            throw new ResourceNotFoundException("Did not find Todo with the id of " + theId);
        }
    }

    @Override
    public TodoListDTO save(TodoListDTO todoListDTO) {
        TodoList todoList = todoDTOMapperReverse.apply(todoListDTO);
        return todoListDTO;
    }

    @Override
    public void deleteById(int theId) {
        todoRepository.deleteById(theId);
    }




}
