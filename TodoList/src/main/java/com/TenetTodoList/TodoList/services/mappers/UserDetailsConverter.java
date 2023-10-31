package com.TenetTodoList.TodoList.services.mappers;

import com.TenetTodoList.TodoList.domain.UserDetail;
import com.TenetTodoList.TodoList.dto.UserDetailDTORequest;
import com.TenetTodoList.TodoList.dto.UserDetailDTOResponse;
import com.TenetTodoList.TodoList.dto.UserDetailDto;

public interface UserDetailsConverter {

    UserDetail convertFromDTO(UserDetailDto dto);
    UserDetailDto convertFromEntity(UserDetail entity);
    UserDetailDTORequest convertFromEntityRequest(UserDetail entity);
    UserDetailDTOResponse convertFromEntityResponse(UserDetail entity);

}