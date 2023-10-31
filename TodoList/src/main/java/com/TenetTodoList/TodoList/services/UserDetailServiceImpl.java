package com.TenetTodoList.TodoList.services;

import com.TenetTodoList.TodoList.dao.UserDetailRepository;
import com.TenetTodoList.TodoList.domain.UserDetail;
import com.TenetTodoList.TodoList.dto.UserDetailDto;
import com.TenetTodoList.TodoList.exceptions.ResourceNotFoundException;
import com.TenetTodoList.TodoList.services.mappers.UserDetailsMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class UserDetailServiceImpl implements UserDetailService{
    private final UserDetailRepository userDetailRepository;
    private final UserDetailsMapper userDetailsMapper;

    public UserDetailServiceImpl(UserDetailRepository userDetailRepository, UserDetailsMapper userDetailsMapper) {
        this.userDetailRepository = userDetailRepository;
        this.userDetailsMapper = userDetailsMapper;
    }
    @Override
    public List<UserDetailDto> findAll() {
        try {
            return userDetailRepository.findAll()
                    .stream()
                    .map(userDetailsMapper::convertFromEntity)
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
            return userDetailsMapper.convertFromEntity(userDetail);
        } else {
            throw new ResourceNotFoundException("Did not find User with the id of " + theId);
        }
    }

    @Override
    public UserDetailDto save(UserDetailDto userDetailDto) {
        try {
            Optional<UserDetail> existingUser = userDetailRepository.findById(userDetailDto.id());
            if (existingUser.isPresent()) {
                UserDetail userDetail = existingUser.get();
                userDetail.setFirstName(userDetailDto.first_name());
                userDetail.setLastName(userDetailDto.last_name());
                userDetail.setCity(userDetailDto.city());
                userDetail.setEmail(userDetailDto.email());
                return userDetailsMapper.convertFromEntity(userDetailRepository.save(userDetail));
            } else {
                throw new ResourceNotFoundException("UserDetail with ID " + userDetailDto.id() + " not found for updating.");
            }
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error while updating user_Detail with ID of " + userDetailDto.id(), e);
        }
    }
    @Override
    public void deleteById(Integer theId) {
        try {
            userDetailRepository.deleteById(theId);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error while deleting user_Detail with the ID of: " + theId, e);
        }
    }
}
