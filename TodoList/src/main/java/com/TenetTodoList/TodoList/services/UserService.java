package com.TenetTodoList.TodoList.services;

import com.TenetTodoList.TodoList.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    List<User> findAll();

    User findById(int theId);

    User save(User user);

    void deleteById(int theId);
}
