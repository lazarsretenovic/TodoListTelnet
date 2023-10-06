package com.TenetTodoList.TodoList.dto;

import com.TenetTodoList.TodoList.domain.TodoList;
import com.TenetTodoList.TodoList.domain.UserDetail;
import com.TenetTodoList.TodoList.services.mappers.UserDetailDTOMapperRequest;
import jakarta.persistence.*;

import java.util.List;

public record UserDTORequest(
        int id,
        String username,
        String password,
        UserDetailDTORequest detail
) {

}
