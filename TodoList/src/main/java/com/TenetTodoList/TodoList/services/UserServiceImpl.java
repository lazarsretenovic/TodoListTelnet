package com.TenetTodoList.TodoList.services;

import com.TenetTodoList.TodoList.dao.UserRepository;
import com.TenetTodoList.TodoList.domain.User;
import com.TenetTodoList.TodoList.dto.UserDTO;
import com.TenetTodoList.TodoList.exceptions.ResourceNotFoundException;
import com.TenetTodoList.TodoList.services.mappers.UserConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserConverter userConverter;


    public UserServiceImpl(UserRepository userRepository,UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }
    @Override
    public List<UserDTO> findAll() {
        try {
            return userRepository.findAll()
                    .stream()
                    .map(userConverter::convertFromEntity)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error while fetching data for users", e);
        }
    }
    @Override
    public UserDTO findById(Integer theId) {
        Optional<User> result = userRepository.findById(theId);
        if (result.isPresent()) {
            User user = result.get();
            return userConverter.convertFromEntity(user);
        } else {
            throw new ResourceNotFoundException("Did not find User with the id of " + theId);
        }
    }
    @Override
    @Transactional
    public UserDTO save(UserDTO userDTO) {
        try {
            Optional<User> existingUser = userRepository.findById(userDTO.id());
            if (existingUser.isPresent()) {
                existingUser.get().setLoginname(userDTO.login_name());
                existingUser.get().setRole(userDTO.role());
                return userConverter.convertFromEntity(userRepository.save(existingUser.get()));
            } else {
                User user = userConverter.convertFromDTO(userDTO);
                userRepository.save(user);
                return userConverter.convertFromEntity(user);
            }
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error while saving User with the ID of:" + userDTO.id(), e);
        }
    }
    @Override
    public void deleteById(Integer theId) {
        try {
            userRepository.deleteById(theId);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error while deleting User with the id of: " + theId, e);
        }
    }

}
