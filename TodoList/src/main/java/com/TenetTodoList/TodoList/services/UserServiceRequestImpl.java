package com.TenetTodoList.TodoList.services;

import com.TenetTodoList.TodoList.dao.UserRepository;
import com.TenetTodoList.TodoList.dto.UserDTORequest;
import com.TenetTodoList.TodoList.exceptions.ResourceNotFoundException;
import com.TenetTodoList.TodoList.services.mappers.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceRequestImpl implements UserServiceRequest {
private final UserRepository userRepository;
private final UserMapper userMapper;

    public UserServiceRequestImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    @Override
    public List<UserDTORequest> findAll() {
        try {
            return userRepository.findAll()
                    .stream()
                    .map(userMapper::convertFromEntityRequest)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error while fetching User data", e);
        }
    }
}
