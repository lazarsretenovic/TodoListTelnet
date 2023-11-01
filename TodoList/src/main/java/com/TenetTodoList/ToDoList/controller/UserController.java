package com.TenetTodoList.ToDoList.controller;

import com.TenetTodoList.ToDoList.dto.UserDTO;
import com.TenetTodoList.ToDoList.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Information about users:")

public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>>findAll() {
        List<UserDTO> userDTOS= userService.findAll();
        return new ResponseEntity<>(userDTOS,HttpStatus.OK);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Integer userId) {
        UserDTO theUser = userService.findById(userId);
        return new ResponseEntity<>(theUser, HttpStatus.OK);
    }
    @PostMapping("/user")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO theUser) {
        UserDTO user = userService.save(theUser);
        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }
    @PutMapping("/user/{userId}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Integer userId, @RequestBody UserDTO updatedUser) {
        UserDTO existingUser = userService.findById(userId);
        UserDTO userToUpdate = new UserDTO(
                userId,
                updatedUser.login_name(),
                updatedUser.role(),
                existingUser.user_detail()
        );
        return new ResponseEntity<>(userService.save(userToUpdate), HttpStatus.OK);
    }
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer userId) {
        UserDTO theUser = userService.findById(userId);
        userService.deleteById(userId);
        return new ResponseEntity<>("Deleted the user by the id of:" + theUser, HttpStatus.OK);
    }
}

