package com.TenetTodoList.TodoList.Dao;

import com.TenetTodoList.TodoList.domain.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoList,Integer> {

}
