package com.TenetTodoList.TodoList.dao;

import com.TenetTodoList.TodoList.domain.UsersRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UsersRole, Integer> {
}
