package com.TenetTodoList.TodoList.dao;

import com.TenetTodoList.TodoList.domain.UserTodos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserTodos, Integer> {

}
