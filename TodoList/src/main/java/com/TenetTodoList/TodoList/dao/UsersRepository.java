package com.TenetTodoList.TodoList.dao;

import com.TenetTodoList.TodoList.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}
