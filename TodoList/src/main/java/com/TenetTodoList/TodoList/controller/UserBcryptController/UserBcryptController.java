//package com.TenetTodoList.TodoList.controller.UserBcryptController;
//
//import com.TenetTodoList.TodoList.dto.dtobcrytpt.UserDTOBcrypt;
//import com.TenetTodoList.TodoList.exceptions.ResourceNotFoundException;
//import com.TenetTodoList.TodoList.services.bcrypt.UserBcryptService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/userscrypt")
//public class UserBcryptController {
//    private final UserBcryptService userService;
//
//    @Autowired
//    public UserBcryptController(UserBcryptService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping
//    public List<UserDTOBcrypt> findAll() {
//        return userService.findAll();
//    }
//
//    @GetMapping("/{userId}")
//    public UserDTOBcrypt getUser(@PathVariable int userId) {
//        UserDTOBcrypt theUser = userService.findById(userId);
//        if (theUser == null) {
//            throw new ResourceNotFoundException("User with id " + userId + " not found");
//        }
//        return theUser;
//    }
//
//    @PostMapping
//    public UserDTOBcrypt addUser(@RequestBody UserDTOBcrypt theUser) {
//        return userService.save(theUser);
//    }
//
//    @PutMapping("/{userId}")
//    public UserDTOBcrypt updateUser(@RequestBody UserDTOBcrypt theUser) {
//        UserDTOBcrypt updatedUser = userService.save(theUser);
//        if (updatedUser == null) {
//            throw new ResourceNotFoundException("User with id " + theUser.getId() + " not found");
//        }
//        return updatedUser;
//    }
//
//    @DeleteMapping("/{userId}")
//    public String deleteUser(@PathVariable int userId) {
//        UserDTOBcrypt theUser = userService.findById(userId);
//        if (theUser == null) {
//            throw new ResourceNotFoundException("User with id " + userId + " not found");
//        }
//        userService.deleteById(userId);
//        return "Deleted the user with id: " + userId;
//    }
//}
