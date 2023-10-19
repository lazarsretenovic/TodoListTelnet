package com.TenetTodoList.TodoList.controller;

import com.TenetTodoList.TodoList.dto.UserDTORequest;
import com.TenetTodoList.TodoList.services.UserServiceRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRequestController {
    private final UserServiceRequest userServiceRequest;
    public UserRequestController(UserServiceRequest userServiceRequest) {
        this.userServiceRequest = userServiceRequest;
    }
    @GetMapping("/user_request")
    public List<UserDTORequest> findAll() {
        return userServiceRequest.findAll();
    }

}