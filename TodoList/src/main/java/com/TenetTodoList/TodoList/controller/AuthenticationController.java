package com.TenetTodoList.TodoList.controller;

import com.TenetTodoList.TodoList.security.JwtAuthenticationResponse;
import com.TenetTodoList.TodoList.security.SignUpRequest;
import com.TenetTodoList.TodoList.security.SingInRequest;
import com.TenetTodoList.TodoList.security.services.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@Tag(name = "Register here:")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
@Operation(
        description = "You sing up here"
)
    @PostMapping("/sign_up")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest request) {
        return new ResponseEntity<>(authenticationService.signup(request),HttpStatus.OK);
    }
    @Operation(
            description = "You sing in here"
    )
    @PostMapping("/sign_in")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SingInRequest request) {
        return new ResponseEntity<>(authenticationService.singin(request),HttpStatus.OK);
    }
}
