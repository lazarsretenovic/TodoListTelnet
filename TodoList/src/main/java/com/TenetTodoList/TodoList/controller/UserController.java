package com.TenetTodoList.TodoList.controller;

import com.TenetTodoList.TodoList.dto.UserDTO;
import com.TenetTodoList.TodoList.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserDTO> findAll(){
        return userService.findAll();
    }

    @GetMapping("/users/{userId}")
    public UserDTO getUser(@PathVariable int userId){
        UserDTO theUser=userService.findById(userId);
        if(theUser==null){
            throw new RuntimeException("User with that id was not found:"+userId);
        }
        return theUser;

    }
    @PostMapping("/users")
    public UserDTO addUser(@RequestBody UserDTO theUser){
        UserDTO user= userService.save(theUser);
        return user;
}
    @PutMapping("/users")
    public UserDTO updateUser(@RequestBody UserDTO theUser){
        UserDTO user=userService.save(theUser);
        return  user;
    }
    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable int userId){
        UserDTO theUser=userService.findById(userId);
        if(theUser == null){
            throw new RuntimeException("User not found"+userId);
        }
        userService.deleteById(userId);
        return "Deleted the user by the id of:"+theUser;
    }

}

