package com.TenetTodoList.TodoList.controller;

import com.TenetTodoList.TodoList.domain.User;
import com.TenetTodoList.TodoList.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.TenetTodoList.TodoList.services.TodoService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable int userId){
        User theUser=userService.findById(userId);
        if(theUser==null){
            throw new RuntimeException("User with that id was not found:"+userId);
        }
        return theUser;

    }
    @PostMapping("/users")
    public User addUser(@RequestBody User theUser){
        theUser.setId(0);
        User user= userService.save(theUser);
        return user;
}
    @PutMapping("/users")
    public User updateUser(@RequestBody User theUser){
        User user=userService.save(theUser);
        return  user;
    }
    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable int userId){
        User theUser=userService.findById(userId);
        if(theUser == null){
            throw new RuntimeException("User not found"+userId);
        }
        userService.deleteById(userId);
        return "Deleted the user by the id of:"+theUser;
    }

}

