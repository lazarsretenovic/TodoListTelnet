package com.TenetTodoList.TodoList.controller;

import com.TenetTodoList.TodoList.dto.TodoListDTOResponse;
import com.TenetTodoList.TodoList.dto.UserDTORequest;
import com.TenetTodoList.TodoList.services.TodoServiceResponse;
import com.TenetTodoList.TodoList.services.UserServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/userrequest")
    public ResponseEntity<UserDTORequest> createUser(@RequestBody UserDTORequest userDTORequest) {
        UserDTORequest savedUser = userServiceRequest.save(userDTORequest);

        // You can customize the response based on whether the user was successfully created
        if (savedUser != null) {
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}