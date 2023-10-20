package com.TenetTodoList.TodoList.controller;

import com.TenetTodoList.TodoList.dto.UserDTO;
import com.TenetTodoList.TodoList.dto.UserDetailDto;
import com.TenetTodoList.TodoList.exceptions.ResourceNotFoundException;
import com.TenetTodoList.TodoList.services.UserDetailService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "User details:")

public class UserDetailController {
    private final UserDetailService userDetailService;
    public UserDetailController(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }
    @GetMapping("/user_details")
    public List<UserDetailDto> findAll() {
        return userDetailService.findAll();
    }

    @GetMapping("/user_details/{userId}")
    public UserDetailDto getUser(@PathVariable int userId) {
        UserDetailDto userDetailDto = userDetailService.findById(userId);
        if (userDetailDto == null) {
            throw new ResourceNotFoundException("User with that id was not found:" + userId);
        }
        return userDetailDto;
    }
    @PostMapping("/user_details")
    public UserDetailDto addUser(@RequestBody UserDetailDto theUser) {
        UserDetailDto user = userDetailService.save(theUser);
        return user;
    }
    @PutMapping ("/user_details/{userId}")
    public UserDetailDto addUser(@PathVariable  int userId ,@RequestBody UserDetailDto updateUserDetailDto) {
        return userDetailService.save(updateUserDetailDto);
    }
}