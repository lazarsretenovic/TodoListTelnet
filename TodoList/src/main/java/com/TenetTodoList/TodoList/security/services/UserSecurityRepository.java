package com.TenetTodoList.TodoList.security.services;

import com.TenetTodoList.TodoList.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface UserSecurityRepository extends JpaRepository<User, Integer> {
    Optional<User> findByLoginname(String loginname);
}

