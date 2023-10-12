package com.TenetTodoList.TodoList.security.services;

import com.TenetTodoList.TodoList.domain.UserTodos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface UserSecurityRepository extends JpaRepository<UserTodos, Integer> {
    Optional<UserTodos> findByUsername(String user_name);
}

