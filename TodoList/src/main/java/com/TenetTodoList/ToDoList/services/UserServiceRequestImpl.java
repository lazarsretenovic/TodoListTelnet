package com.TenetTodoList.ToDoList.services;

import com.TenetTodoList.ToDoList.dao.UserRepository;
import com.TenetTodoList.ToDoList.dto.UserDTORequest;
import com.TenetTodoList.ToDoList.exceptions.ResourceNotFoundException;
import com.TenetTodoList.ToDoList.services.mappers.UserToDoListMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceRequestImpl implements UserServiceRequest {
private final UserRepository userRepository;
private final UserToDoListMapper userTodoListMapper;

    public UserServiceRequestImpl(UserRepository userRepository, UserToDoListMapper userTodoListMapper) {
        this.userRepository = userRepository;
        this.userTodoListMapper = userTodoListMapper;
    }
    @Override
    public List<UserDTORequest> findAll() {
        try {
            return userRepository.findAll()
                    .stream()
                    .map(userTodoListMapper::UserDTORequestFromEntityToDto)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error while fetching User data", e);
        }
    }
}
