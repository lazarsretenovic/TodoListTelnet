package com.TenetTodoList.TodoList.security.services;

import com.TenetTodoList.TodoList.dto.UserDTOWhoAmI;
import com.TenetTodoList.TodoList.security.JwtAuthenticationResponse;
import com.TenetTodoList.TodoList.security.SignUpRequest;
import com.TenetTodoList.TodoList.security.SingInRequest;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse singin(SingInRequest request);

    UserDTOWhoAmI loadUserByLoginname(String loginname);
}