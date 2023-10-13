package com.TenetTodoList.TodoList.services;

import com.TenetTodoList.TodoList.dao.UserRepository;
import com.TenetTodoList.TodoList.domain.User;
import com.TenetTodoList.TodoList.dto.UserDTO;
import com.TenetTodoList.TodoList.exceptions.ResourceNotFoundException;
import com.TenetTodoList.TodoList.services.mappers.TodoDTOMapper;
import com.TenetTodoList.TodoList.services.mappers.UserDTOMapper;
import com.TenetTodoList.TodoList.services.mappers.UserDTOMapperReverse;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserDTOMapper userDTOMapper;
    private final UserDTOMapperReverse userDTOMapperReverse;
    private final TodoDTOMapper todoDTOMapper;

    public UserServiceImpl(UserRepository userRepository, UserDTOMapper userDTOMapper, UserDTOMapperReverse userDTOMapperReverse, TodoDTOMapper todoDTOMapper) {
        this.userRepository = userRepository;
        this.userDTOMapper = userDTOMapper;
        this.userDTOMapperReverse = userDTOMapperReverse;
        this.todoDTOMapper = todoDTOMapper;
    }
    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userDTOMapper::apply)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(int theId) {
        Optional<User> result = userRepository.findById(theId);
        if (result.isPresent()) {
            User user = result.get();
            return userDTOMapper.apply(user);
        } else {
            throw new ResourceNotFoundException("Did not find User with the id of " + theId);
        }
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        User user = userDTOMapperReverse.apply(userDTO);
        Optional<User> existingUser = userRepository.findById(user.getId());
        if (existingUser.isPresent()) {
            User updatedUser = existingUser.get();
            updatedUser.getLoginname();
            updatedUser.setPassword(user.getPassword());
            userRepository.save(updatedUser);
        } else {
            userRepository.save(user);
        }
        return userDTO;
    }


    @Override
    public void deleteById(int theId) {
        userRepository.deleteById(theId);
    }

}
