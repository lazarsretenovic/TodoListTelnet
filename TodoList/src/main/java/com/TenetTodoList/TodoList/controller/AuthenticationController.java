package com.TenetTodoList.TodoList.controller;

import com.TenetTodoList.TodoList.security.JwtAuthenticationResponse;
import com.TenetTodoList.TodoList.security.SignUpRequest;
import com.TenetTodoList.TodoList.security.SinginRequest;
import com.TenetTodoList.TodoList.security.services.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SinginRequest request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }
}
