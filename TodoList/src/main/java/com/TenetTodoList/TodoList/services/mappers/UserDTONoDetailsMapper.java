package com.TenetTodoList.TodoList.services.mappers;

import com.TenetTodoList.TodoList.domain.User;
import com.TenetTodoList.TodoList.dto.UserDTONoDetails;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@Component
public class UserDTONoDetailsMapper implements Function<User, UserDTONoDetails> {
    @Override
    public UserDTONoDetails apply(User user) {
        UserDTONoDetails userDTONoDetails= new UserDTONoDetails(
                user.getId());
        return userDTONoDetails;
    }
}
