package com.TenetTodoList.TodoList.security.services;

import com.TenetTodoList.TodoList.security.JwtAuthenticationResponse;
import com.TenetTodoList.TodoList.security.SignUpRequest;
import com.TenetTodoList.TodoList.security.SinginRequest;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SinginRequest request);

    UserDetails loadUserByLoginname(String loginname);
}