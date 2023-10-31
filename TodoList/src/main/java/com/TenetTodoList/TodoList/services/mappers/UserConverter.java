package com.TenetTodoList.TodoList.services.mappers;

import com.TenetTodoList.TodoList.domain.User;
import com.TenetTodoList.TodoList.dto.*;

public interface UserConverter {

    User convertFromDTO(UserDTO dto);
    UserDTO convertFromEntity(User entity);
    UserDTONoDetails convertFromEntityNoDetails(User entity);
    UserDTORequest convertFromEntityRequest(User entity);
    UserDTOResponse convertFromEntityResponse(User entity);
    UserDTOWhoAmI convertFromEntityWhoAmI(User entity);



}
