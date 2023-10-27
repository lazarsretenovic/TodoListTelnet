package com.TenetTodoList.TodoList.controller;

import com.TenetTodoList.TodoList.dto.UserDTOWhoAmI;
import com.TenetTodoList.TodoList.security.services.AuthenticationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api")
@Tag(name = "Who am i?")

public class WhoAmIController {
    private final AuthenticationService authenticationService;
    private static final Logger logger = LoggerFactory.getLogger(WhoAmIController.class);

    public WhoAmIController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
    @GetMapping("/who_am_i")
    public ResponseEntity<UserDTOWhoAmI> getUserProfile(Authentication authentication) {
        String username = authentication.getName();
        UserDTOWhoAmI userDTOWhoAmI = authenticationService.loadUserByLoginname(username);
        logger.info("Controller works");
        return new ResponseEntity<>(userDTOWhoAmI, HttpStatus.OK);
    }
}