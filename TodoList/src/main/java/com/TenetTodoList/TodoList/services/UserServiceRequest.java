package com.TenetTodoList.TodoList.services;

import com.TenetTodoList.TodoList.dto.UserDTORequest;

import java.util.List;
public interface UserServiceRequest {
    List<UserDTORequest> findAll();
}
