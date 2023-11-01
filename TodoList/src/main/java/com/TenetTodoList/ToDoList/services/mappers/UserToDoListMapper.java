package com.TenetTodoList.ToDoList.services.mappers;

import com.TenetTodoList.ToDoList.domain.ToDoList;
import com.TenetTodoList.ToDoList.domain.User;
import com.TenetTodoList.ToDoList.dto.*;

public interface UserToDoListMapper {
    ToDoListDTORequest TodoListRequestFromEntityToDto(ToDoList entity);
    ToDoListDTOResponse TodoListResponseFromEntityToDto(ToDoList entity);
    UserDTOBaseInfo UserBaseIfoEntityToDto(User entity);
    UserDTORequest UserDTORequestFromEntityToDto(User entity);
    UserDTOResponse UserDTOResponseFromEntityToDto(User entity);
}
