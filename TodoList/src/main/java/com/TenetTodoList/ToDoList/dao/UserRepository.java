package com.TenetTodoList.ToDoList.dao;

import com.TenetTodoList.ToDoList.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
