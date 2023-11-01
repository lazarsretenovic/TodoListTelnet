package com.TenetTodoList.ToDoList.security.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserSecurityService {
    UserDetailsService userDetailsService();
}