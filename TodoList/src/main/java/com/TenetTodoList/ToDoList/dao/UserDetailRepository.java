package com.TenetTodoList.ToDoList.dao;

import com.TenetTodoList.ToDoList.domain.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail,Integer> {
}
