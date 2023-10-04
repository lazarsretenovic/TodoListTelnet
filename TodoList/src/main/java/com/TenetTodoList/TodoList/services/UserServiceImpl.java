package com.TenetTodoList.TodoList.services;

import com.TenetTodoList.TodoList.Dao.UserRepository;
import com.TenetTodoList.TodoList.domain.TodoList;
import com.TenetTodoList.TodoList.domain.User;
import com.TenetTodoList.TodoList.dto.TodoListDTO;
import com.TenetTodoList.TodoList.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> findAll() {
        return  userRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(int theId) {
        Optional<User> result = userRepository.findById(theId);
        if (result.isPresent()) {
            User user = result.get();
            return convertEntityToDto(user); // Convert the entity to DTO
        } else {
            throw new RuntimeException("Did not find Todo with the id of " + theId);
        }
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        User user = convertDtoToEntity(userDTO);
        return convertEntityToDto(userRepository.save(user));
    }

    @Override
    public void deleteById(int theId) {
        userRepository.deleteById(theId);
    }
    private UserDTO convertEntityToDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setUserDetail(user.getUserDetail());
        return userDTO;
    }
    private User convertDtoToEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setUserDetail(userDTO.getUserDetail());
        return user;
    }
}
