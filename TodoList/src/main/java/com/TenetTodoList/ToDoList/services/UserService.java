package com.TenetTodoList.ToDoList.services;

import com.TenetTodoList.ToDoList.dto.UserDTO;

import java.util.List;
public interface UserService {
    List<UserDTO> findAll();

    UserDTO findById(Integer theId);

    UserDTO save(UserDTO userDTO);

    void deleteById(Integer theId);

}
