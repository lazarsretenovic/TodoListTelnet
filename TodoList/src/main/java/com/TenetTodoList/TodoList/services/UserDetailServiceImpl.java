package com.TenetTodoList.TodoList.services;

import com.TenetTodoList.TodoList.dao.UserDetailRepository;
import com.TenetTodoList.TodoList.dto.UserDetailDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserDetailServiceImpl implements UserDetailService{

    private UserDetailRepository userDetailRepository;

    private final UserDetailDTOMapper userDetailDTOMapper;
    private final UserDetailDTOMapperReverse userDetailDTOMapperReverse;

    public UserDetailServiceImpl(UserDetailRepository userDetailRepository, UserDetailDTOMapper userDetailDTOMapper, UserDetailDTOMapperReverse userDetailDTOMapperReverse) {
        this.userDetailRepository = userDetailRepository;
        this.userDetailDTOMapper = userDetailDTOMapper;
        this.userDetailDTOMapperReverse = userDetailDTOMapperReverse;
    }

    @Override
    public List<UserDetailDto> findAll() {
        return userDetailRepository.findAll()
                .stream()
                .map(userDetailDTOMapper)
                .collect(Collectors.toList());
    }

    @Override
    public UserDetailDto findById(int theId) {
        return null;
    }

    @Override
    public UserDetailDto save(UserDetailDto userDetailDto) {
        return null;
    }

    @Override
    public void deleteById(int theId) {

    }
}
