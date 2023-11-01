package com.TenetTodoList.ToDoList.services.mappers;

import com.TenetTodoList.ToDoList.domain.User;
import com.TenetTodoList.ToDoList.dto.*;

public interface UserMapper {

    User UserFromDtoToEntity(UserDTO dto);
    UserDTO UserFromEntityToDto(User entity);
    UserDTOBaseInfo convertFromEntityBaseInfo(User entity);
    UserDTOResponse UserDTOResponseFromEntityToDto(User entity);
    UserDTOWhoAmI convertFromEntityWhoAmI(User entity);



}
