package com.TenetTodoList.ToDoList.security.services;

import com.TenetTodoList.ToDoList.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface UserSecurityRepository extends JpaRepository<User, Integer> {
    Optional<User> findByLoginname(String loginname);
}

