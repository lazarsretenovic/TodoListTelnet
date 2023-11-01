package com.TenetTodoList.ToDoList.services;

import com.TenetTodoList.ToDoList.dao.UserRepository;
import com.TenetTodoList.ToDoList.domain.User;
import com.TenetTodoList.ToDoList.dto.UserDTO;
import com.TenetTodoList.ToDoList.exceptions.ResourceNotFoundException;
import com.TenetTodoList.ToDoList.services.mappers.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    @Override
    public List<UserDTO> findAll() {
        try {
            return userRepository.findAll()
                    .stream()
                    .map(userMapper::UserFromEntityToDto)
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
            return userMapper.UserFromEntityToDto(user);
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
                return userMapper.UserFromEntityToDto(userRepository.save(existingUser.get()));
            } else {
                User user = userMapper.UserFromDtoToEntity(userDTO);
                userRepository.save(user);
                return userMapper.UserFromEntityToDto(user);
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
