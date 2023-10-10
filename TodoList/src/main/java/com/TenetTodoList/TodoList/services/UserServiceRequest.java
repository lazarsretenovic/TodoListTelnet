package com.TenetTodoList.TodoList.services;

import com.TenetTodoList.TodoList.dto.TodoListDTOResponse;
import com.TenetTodoList.TodoList.dto.UserDTO;
import com.TenetTodoList.TodoList.dto.UserDTORequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserServiceRequest {
    List<UserDTORequest> findAll();
    UserDTORequest save(UserDTORequest userDTORequest);
}
