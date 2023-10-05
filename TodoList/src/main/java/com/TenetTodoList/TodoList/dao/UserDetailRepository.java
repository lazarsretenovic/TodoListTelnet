package com.TenetTodoList.TodoList.dao;

import com.TenetTodoList.TodoList.domain.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepository extends JpaRepository<UserDetail,Integer> {
}
