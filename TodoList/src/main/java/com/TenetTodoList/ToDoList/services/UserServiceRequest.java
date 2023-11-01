package com.TenetTodoList.ToDoList.services;

import com.TenetTodoList.ToDoList.dto.UserDTORequest;

import java.util.List;
public interface UserServiceRequest {
    List<UserDTORequest> findAll();
}
