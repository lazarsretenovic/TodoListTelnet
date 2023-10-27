package com.TenetTodoList.TodoList.controller;

import com.TenetTodoList.TodoList.dto.UserDetailDto;
import com.TenetTodoList.TodoList.services.UserDetailService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Details about user:")

public class UserDetailController {
    private final UserDetailService userDetailService;
    public UserDetailController(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }
    @GetMapping("/user_details")
    public ResponseEntity<List<UserDetailDto>> findAll() {
        List<UserDetailDto> userDetailDtos = userDetailService.findAll();
        return new ResponseEntity<>(userDetailDtos, HttpStatus.OK);
    }

    @GetMapping("/user_detail/{userId}")
    public ResponseEntity<UserDetailDto> getUser(@PathVariable int userId) {
        UserDetailDto userDetailDto = userDetailService.findById(userId);
        if (userDetailDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userDetailDto, HttpStatus.OK);
    }

    @PostMapping("/user_detail")
    public ResponseEntity<UserDetailDto> addUser(@RequestBody UserDetailDto theUser) {
        UserDetailDto user = userDetailService.save(theUser);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/user_detail/{userId}")
    public ResponseEntity<UserDetailDto> updateUser(@PathVariable int userId, @RequestBody UserDetailDto updateUserDetailDto) {
        UserDetailDto updatedUserDetail = userDetailService.save(updateUserDetailDto);
        if (updatedUserDetail == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedUserDetail, HttpStatus.OK);
    }
}