package com.TenetTodoList.ToDoList.services.mappers;
import com.TenetTodoList.ToDoList.domain.UserDetail;
import com.TenetTodoList.ToDoList.dto.UserDetailDTORequest;
import com.TenetTodoList.ToDoList.dto.UserDetailDTOResponse;
import com.TenetTodoList.ToDoList.dto.UserDetailDto;

public interface UserDetailsMapper {

    UserDetail UserDetailDtoTOEntity(UserDetailDto dto);
    UserDetailDto UserDetailFromEntityToDto(UserDetail entity);
    UserDetailDTORequest UserDetailRequestFromEntityToDto(UserDetail entity);
    UserDetailDTOResponse UserDetailResponseFromEntityToDto(UserDetail entity);

}
