package com.TenetTodoList.TodoList.services;

import com.TenetTodoList.TodoList.dao.UserDetailRepository;
import com.TenetTodoList.TodoList.domain.UserDetail;
import com.TenetTodoList.TodoList.dto.UserDetailDto;
import com.TenetTodoList.TodoList.exceptions.ResourceNotFoundException;
import com.TenetTodoList.TodoList.services.mappers.UserDetailDTOMapper;
import com.TenetTodoList.TodoList.services.mappers.UserDetailDTOMapperReverse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class UserDetailServiceImpl implements UserDetailService{

    private final UserDetailRepository userDetailRepository;

    private final UserDetailDTOMapper userDetailDTOMapper;
    private final UserDetailDTOMapperReverse userDetailDTOMapperReverse;

    public UserDetailServiceImpl(UserDetailRepository userDetailRepository, UserDetailDTOMapper userDetailDTOMapper, UserDetailDTOMapperReverse userDetailDTOMapperReverse) {
        this.userDetailRepository = userDetailRepository;
        this.userDetailDTOMapper = userDetailDTOMapper;
        this.userDetailDTOMapperReverse = userDetailDTOMapperReverse;
    }

    @Override
    public List<UserDetailDto> findAll() {
        try {
            return userDetailRepository.findAll()
                    .stream()
                    .map(userDetailDTOMapper)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error while fetching user details", e);
        }
    }

    @Override
    public UserDetailDto findById(Integer theId) {

        Optional<UserDetail> result = userDetailRepository.findById(theId);
        if (result.isPresent()) {
            UserDetail userDetail = result.get();
            return userDetailDTOMapper.apply(userDetail);
        } else {
            throw new ResourceNotFoundException("Did not find User with the id of " + theId);
        }
    }

    @Override
    public UserDetailDto save(UserDetailDto userDetailDto) {
        try {
            Optional<UserDetail> existingUser = userDetailRepository.findById(userDetailDto.id());
            if (existingUser.isPresent()) {
                existingUser.get().setId(userDetailDto.id());
                existingUser.get().setFirstName(userDetailDto.first_name());
                existingUser.get().setLastName(userDetailDto.last_name());
                existingUser.get().setEmail(userDetailDto.email());
                existingUser.get().setCity(userDetailDto.city());
                return userDetailDTOMapper.apply(userDetailRepository.save(existingUser.get()));
            } else {
                UserDetail userDetail = userDetailDTOMapperReverse.apply(userDetailDto);
                userDetailRepository.save(userDetail);
                return userDetailDTOMapper.apply(userDetail);
            }
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error while saving user_Detail with ID of" + userDetailDto.id(), e);
        }
    }


    @Override
    public void deleteById(Integer theId) {
    }
}
