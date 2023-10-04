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
    private TodoListDTO convertEntityToDto(TodoList todo){
        TodoListDTO todoListDTO = new TodoListDTO();
        todoListDTO.setId(todo.getId());
        todoListDTO.setDescription(todo.getDescription());
        todoListDTO.setStatus(todo.getStatus());
        todoListDTO.setUser(todo.getUser());
        return todoListDTO;


    }
}
