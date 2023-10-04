package com.TenetTodoList.TodoList.services;

import com.TenetTodoList.TodoList.domain.User;
import com.TenetTodoList.TodoList.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    List<UserDTO> findAll();

    UserDTO findById(int theId);

    UserDTO save(UserDTO userDTO);

    void deleteById(int theId);

    private UserDTO convertDtoToEntity(User user){
        UserDTO userDTO= new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setUserDetail(user.getUserDetail());
        return  userDTO;
    }
}
