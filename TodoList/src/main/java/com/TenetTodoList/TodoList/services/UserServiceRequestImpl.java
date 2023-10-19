package com.TenetTodoList.TodoList.services;

import com.TenetTodoList.TodoList.dao.UserRepository;
import com.TenetTodoList.TodoList.domain.User;
import com.TenetTodoList.TodoList.dto.UserDTORequest;
import com.TenetTodoList.TodoList.exceptions.ResourceNotFoundException;
import com.TenetTodoList.TodoList.services.mappers.UserDTOMapperRequest;
import com.TenetTodoList.TodoList.services.mappers.UserDTOMapperRequestReverse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceRequestImpl implements UserServiceRequest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDTOMapperRequest userDTOMapperRequest;
    @Autowired
    private UserDTOMapperRequestReverse userDTOMapperRequestReverse;

    @Override
    public List<UserDTORequest> findAll() {
        try {
            return userRepository.findAll()
                    .stream()
                    .map(userDTOMapperRequest::apply)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error while fetching User data", e);
        }
    }


}
