package com.TenetTodoList.TodoList.dao;

import com.TenetTodoList.TodoList.domain.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail,Integer> {
}
