package com.TenetTodoList.TodoList.controller;

import com.TenetTodoList.TodoList.dto.UserDTO;
import com.TenetTodoList.TodoList.services.UserService;
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
    public ResponseEntity<UserDTO> getUser(@PathVariable int userId) {
        UserDTO theUser = userService.findById(userId);
        if (theUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(theUser, HttpStatus.OK);
    }
    @PostMapping("/user")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO theUser) {
        UserDTO user = userService.save(theUser);
        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }
    @PutMapping("/user/{userId}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable int userId, @RequestBody UserDTO updatedUser) {
        UserDTO existingUser = userService.findById(userId);
        if (existingUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        UserDTO userToUpdate = new UserDTO(
                userId,
                updatedUser.login_name(),
                updatedUser.role(),
                existingUser.user_detail()
        );
        return new ResponseEntity<>(userService.save(userToUpdate), HttpStatus.OK);
    }
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable int userId) {
        UserDTO theUser = userService.findById(userId);
        if (theUser == null) {
            return new ResponseEntity<>("User not found" + userId, HttpStatus.NOT_FOUND);
        }
        userService.deleteById(userId);
        return new ResponseEntity<>("Deleted the user by the id of:" + theUser, HttpStatus.OK);
    }
}

