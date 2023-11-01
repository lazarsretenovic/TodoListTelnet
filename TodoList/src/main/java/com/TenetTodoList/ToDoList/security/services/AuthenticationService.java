package com.TenetTodoList.ToDoList.security.services;

import com.TenetTodoList.ToDoList.dto.UserDTOWhoAmI;
import com.TenetTodoList.ToDoList.security.JwtAuthenticationResponse;
import com.TenetTodoList.ToDoList.security.SignUpRequest;
import com.TenetTodoList.ToDoList.security.SingInRequest;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse singin(SingInRequest request);

    UserDTOWhoAmI loadUserByLoginname(String loginname);
}