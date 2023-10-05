package com.TenetTodoList.TodoList.controller;

import com.TenetTodoList.TodoList.dto.UserDetailDto;
import com.TenetTodoList.TodoList.services.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserDetailController {
    @Autowired
    private final UserDetailService userDetailService;

    public UserDetailController(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }
@GetMapping("/userdetails")
    public List<UserDetailDto> findAll(){
        return userDetailService.findAll();
}

}
