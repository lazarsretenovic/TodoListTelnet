package com.TenetTodoList.TodoList.services.mappers;

import com.TenetTodoList.TodoList.domain.TodoList;
import com.TenetTodoList.TodoList.domain.User;
import com.TenetTodoList.TodoList.domain.UserDetail;
import com.TenetTodoList.TodoList.dto.TodoListDTO;
import com.TenetTodoList.TodoList.dto.UserDTO;
import com.TenetTodoList.TodoList.dto.UserDTONoDetails;
import com.TenetTodoList.TodoList.dto.UserDetailDto;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TodoDTOMapperReverse implements Function<TodoListDTO, TodoList> {
@Override
    public TodoList apply(TodoListDTO todoListDTO){
        UserDTONoDetails userDTO= todoListDTO.user();

        User user= new User(userDTO.id());
        return new TodoList(
                todoListDTO.id(),
                todoListDTO.description(),
                todoListDTO.status(),
                user
        );
    }


}