package com.TenetTodoList.TodoList.services.bcrypt;

import com.TenetTodoList.TodoList.dto.UserDTO;
import com.TenetTodoList.TodoList.dto.dtobcrytpt.UserDTOBcrypt;

import java.util.List;

public interface UserBcryptService {
    List<UserDTOBcrypt> findAll();

    UserDTOBcrypt findById(int theId);

    UserDTOBcrypt save(UserDTOBcrypt userDTO);

    void deleteById(int theId);
}
