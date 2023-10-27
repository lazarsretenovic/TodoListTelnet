package com.TenetTodoList.TodoList.services;

import com.TenetTodoList.TodoList.dao.UserRepository;
import com.TenetTodoList.TodoList.domain.User;
import com.TenetTodoList.TodoList.domain.UserDetail;
import com.TenetTodoList.TodoList.dto.UserDTO;
import com.TenetTodoList.TodoList.exceptions.ResourceNotFoundException;
import com.TenetTodoList.TodoList.services.mappers.TodoDTOMapper;
import com.TenetTodoList.TodoList.services.mappers.UserDTOMapper;
import com.TenetTodoList.TodoList.services.mappers.UserDTOMapperReverse;
import com.TenetTodoList.TodoList.services.mappers.UserDetailDTOMapperReverse;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserDTOMapper userDTOMapper;
    private final UserDTOMapperReverse userDTOMapperReverse;
    private final UserDetailDTOMapperReverse userDetailDTOMapperReverse;


    public UserServiceImpl(UserRepository userRepository, UserDTOMapper userDTOMapper, UserDTOMapperReverse userDTOMapperReverse, TodoDTOMapper todoDTOMapper, UserDetailDTOMapperReverse userDetailDTOMapperReverse) {
        this.userRepository = userRepository;
        this.userDTOMapper = userDTOMapper;
        this.userDTOMapperReverse = userDTOMapperReverse;
        this.userDetailDTOMapperReverse = userDetailDTOMapperReverse;
    }
    @Override
    public List<UserDTO> findAll() {
        try {
            return userRepository.findAll()
                    .stream()
                    .map(userDTOMapper::apply)
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
            return userDTOMapper.apply(user);
        } else {
            throw new ResourceNotFoundException("Did not find User with the id of " + theId);
        }
    }
    @Override
    public UserDTO save(UserDTO userDTO) {
        try {
            Optional<User> existingUser = userRepository.findById(userDTO.id());
            if (existingUser.isPresent()) {
                existingUser.get().setLoginname(userDTO.login_name());
                existingUser.get().setRole(userDTO.role());
                UserDetail userDetail = userDetailDTOMapperReverse.apply(userDTO.user_detail());
                existingUser.get().setUserDetail(userDetail);
                return userDTOMapper.apply(userRepository.save(existingUser.get()));
            } else {
                User user = userDTOMapperReverse.apply(userDTO);
                userRepository.save(user);
                return userDTOMapper.apply(user);
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
