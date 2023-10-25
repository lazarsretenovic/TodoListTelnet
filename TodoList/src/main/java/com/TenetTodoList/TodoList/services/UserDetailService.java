package com.TenetTodoList.TodoList.services;

import com.TenetTodoList.TodoList.dto.UserDetailDto;

import java.util.List;

public interface UserDetailService {
    List<UserDetailDto> findAll();

    UserDetailDto findById(Integer theId);

    UserDetailDto save(UserDetailDto userDetailDto);

    void deleteById(Integer theId);
}
