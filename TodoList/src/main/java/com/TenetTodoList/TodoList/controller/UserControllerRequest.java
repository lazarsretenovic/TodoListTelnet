package com.TenetTodoList.TodoList.controller;

import com.TenetTodoList.TodoList.dto.TodoListDTOResponse;
import com.TenetTodoList.TodoList.dto.UserDTORequest;
import com.TenetTodoList.TodoList.services.TodoServiceResponse;
import com.TenetTodoList.TodoList.services.UserServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserControllerRequest {
    private final UserServiceRequest userServiceRequest;

    public UserControllerRequest(UserServiceRequest userServiceRequest) {
        this.userServiceRequest = userServiceRequest;
    }

    @GetMapping("/userrequest")
    public List<UserDTORequest> findAll() {
        return userServiceRequest.findAll();
    }
}