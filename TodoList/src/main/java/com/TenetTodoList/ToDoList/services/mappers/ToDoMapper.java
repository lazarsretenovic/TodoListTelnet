package com.TenetTodoList.ToDoList.services.mappers;

import com.TenetTodoList.ToDoList.domain.ToDoList;
import com.TenetTodoList.ToDoList.dto.ToDoListDTO;
import com.TenetTodoList.ToDoList.dto.ToDoListDTORequest;
import com.TenetTodoList.ToDoList.dto.ToDoListDTOResponse;

public interface ToDoMapper {
    ToDoList TodoListFromDtoToEntity(ToDoListDTO dto);
    ToDoListDTO TodoListFromEntityToDto(ToDoList entity);
    ToDoListDTORequest TodoListRequestFromEntityToDto(ToDoList entity);
    ToDoListDTOResponse TodoListResponseFromEntityToDto(ToDoList entity);
}
