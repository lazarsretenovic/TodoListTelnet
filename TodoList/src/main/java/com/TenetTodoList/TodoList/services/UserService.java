package com.TenetTodoList.TodoList.services;

import com.TenetTodoList.TodoList.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;
public interface UserService {
    List<UserDTO> findAll();

    UserDTO findById(Integer theId);

    UserDTO save(UserDTO userDTO);

    void deleteById(Integer theId);

}
