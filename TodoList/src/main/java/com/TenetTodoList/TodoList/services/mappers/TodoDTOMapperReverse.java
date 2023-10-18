package com.TenetTodoList.TodoList.services.mappers;

import com.TenetTodoList.TodoList.domain.TodoList;
import com.TenetTodoList.TodoList.domain.User;
import com.TenetTodoList.TodoList.domain.UserDetail;
import com.TenetTodoList.TodoList.dto.TodoListDTO;
import com.TenetTodoList.TodoList.dto.UserDTO;
import com.TenetTodoList.TodoList.dto.UserDetailDto;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TodoDTOMapperReverse implements Function<TodoListDTO, TodoList> {
@Override
    public TodoList apply(TodoListDTO todoListDTO){
        UserDTO userDTO= todoListDTO.user();
        UserDetailDto userDetailDto = userDTO.user_detail();
        UserDetail userDetail = new UserDetail(
                userDetailDto.id(),
                userDetailDto.firstName(),
                userDetailDto.lastName(),
                userDetailDto.email(),
                userDetailDto.city()
        );
        User user= new User(
                userDTO.id(),
                userDTO.login_name(),
                userDTO.password(),
              userDetail
        );
        return new TodoList(
                todoListDTO.id(),
                todoListDTO.description(),
                todoListDTO.status(),
                user
        );
    }


}