package com.TenetTodoList.ToDoList.services;

import com.TenetTodoList.ToDoList.dto.UserDetailDto;

import java.util.List;

public interface UserDetailService {
    List<UserDetailDto> findAll();

    UserDetailDto findById(Integer theId);

    UserDetailDto save(UserDetailDto userDetailDto);

    void deleteById(Integer theId);
}
