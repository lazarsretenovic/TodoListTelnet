package com.TenetTodoList.TodoList.services;

import com.TenetTodoList.TodoList.dto.TodoListDTO;
import com.TenetTodoList.TodoList.dto.UserDetailDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserDetailService {
    List<UserDetailDto> findAll();

    UserDetailDto findById(int theId);

    UserDetailDto save(UserDetailDto userDetailDto);

    void deleteById(int theId);
}
