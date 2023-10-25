package com.TenetTodoList.TodoList.security.services;

import com.TenetTodoList.TodoList.dto.UserDtoWho;
import com.TenetTodoList.TodoList.security.JwtAuthenticationResponse;
import com.TenetTodoList.TodoList.security.SignUpRequest;
import com.TenetTodoList.TodoList.security.SinginRequest;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SinginRequest request);

    UserDtoWho loadUserByLoginname(String loginname);
}