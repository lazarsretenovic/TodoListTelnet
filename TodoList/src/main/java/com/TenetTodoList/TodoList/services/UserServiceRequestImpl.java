package com.TenetTodoList.TodoList.services;
import com.TenetTodoList.TodoList.dao.TodoRepository;
import com.TenetTodoList.TodoList.dao.UserRepository;
import com.TenetTodoList.TodoList.dto.UserDTORequest;
import com.TenetTodoList.TodoList.services.mappers.UserDTOMapperRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceRequestImpl implements UserServiceRequest{

    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private UserDTOMapperRequest userDTOMapperRequest;


    @Override
    public List<UserDTORequest> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userDTOMapperRequest::apply)
                .collect(Collectors.toList());

    }
}
