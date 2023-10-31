package com.TenetTodoList.TodoList.services.mappers;

import com.TenetTodoList.TodoList.domain.TodoList;
import com.TenetTodoList.TodoList.dto.TodoListDTO;
import com.TenetTodoList.TodoList.dto.TodoListDTORequest;
import com.TenetTodoList.TodoList.dto.TodoListDTOResponse;

public interface TodoListConverter {
    TodoList convertFromDTO(TodoListDTO dto);
    TodoListDTO convertFromEntity(TodoList entity);
    TodoListDTORequest convertFromEntityRequest(TodoList entity);
    TodoListDTOResponse convertFromEntityResponse(TodoList entity);


}
