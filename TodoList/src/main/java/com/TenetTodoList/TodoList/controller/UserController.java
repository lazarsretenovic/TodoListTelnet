package com.TenetTodoList.TodoList.controller;

import com.TenetTodoList.TodoList.dto.UserDTO;
import com.TenetTodoList.TodoList.exceptions.ResourceNotFoundException;
import com.TenetTodoList.TodoList.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
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
    public List<UserDTO> findAll() {
        return userService.findAll();
    }

    @GetMapping("/user/{userId}")
    public UserDTO getUser(@PathVariable int userId) {
        UserDTO theUser = userService.findById(userId);
        if (theUser == null) {
            throw new ResourceNotFoundException("User with that id was not found:" + userId);
        }
        return theUser;
    }

    @PostMapping("/user")
    public UserDTO addUser(@RequestBody UserDTO theUser) {
        UserDTO user = userService.save(theUser);
        return user;
    }

    @PutMapping("/user/{userId}")
    public UserDTO updateUser(@PathVariable int userId, @RequestBody UserDTO updatedUser) {
        UserDTO existingUser = userService.findById(userId);
        if (existingUser == null) {
            throw new ResourceNotFoundException("User with ID " + userId + " not found.");
        }
        UserDTO userToUpdate = new UserDTO(
                userId,
                updatedUser.login_name(),
                updatedUser.password(),
                updatedUser.role(),
                existingUser.user_detail()
        );

        return userService.save(userToUpdate);
    }

    @DeleteMapping("/user/{userId}")
    public String deleteUser(@PathVariable int userId) {
        UserDTO theUser = userService.findById(userId);
        if (theUser == null) {
            throw new ResourceNotFoundException("User not found" + userId);
        }
        userService.deleteById(userId);
        return "Deleted the user by the id of:" + theUser;
    }
}

