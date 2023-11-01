package com.TenetTodoList.ToDoList.dao;

import com.TenetTodoList.ToDoList.domain.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDoList,Integer> {
}
