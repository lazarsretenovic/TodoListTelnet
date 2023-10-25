package com.TenetTodoList.TodoList.controller;

import com.TenetTodoList.TodoList.dto.UserDtoWho;
import com.TenetTodoList.TodoList.security.services.AuthenticationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/api")
@Tag(name = "Who am i?")

public class WhoAmIController {
    private final AuthenticationService authenticationService;
    private static final Logger logger = LoggerFactory.getLogger(WhoAmIController.class);

    public WhoAmIController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
    @GetMapping("/who_am_i_controller")
    public UserDtoWho getUserProfile(Authentication authentication) {
        String username = authentication.getName();
        UserDtoWho userDetails = authenticationService.loadUserByLoginname(username);
        logger.info("Controller works");
        return userDetails;
    }
}