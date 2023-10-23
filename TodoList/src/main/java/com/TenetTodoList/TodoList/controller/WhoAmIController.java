package com.TenetTodoList.TodoList.controller;

import com.TenetTodoList.TodoList.security.services.AuthenticationService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WhoAmIController {
    private final AuthenticationService authenticationService;

    public WhoAmIController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


    @GetMapping("/profile")
    public UserDetails getUserProfile(Authentication authentication) {
        String username = authentication.getName();
        UserDetails userDetails = authenticationService.loadUserByLoginname(username);
        return userDetails;
    }
}