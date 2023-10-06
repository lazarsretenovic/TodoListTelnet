package com.TenetTodoList.TodoList.services.mappers;

import com.TenetTodoList.TodoList.domain.UserDetail;
import com.TenetTodoList.TodoList.dto.UserDetailDTOResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@Component
public class UserDetailDTOMapperResponse implements Function<UserDetail, UserDetailDTOResponse> {
    public UserDetailDTOResponse apply(UserDetail userDetail){
        return new UserDetailDTOResponse(

                userDetail.getFirstName(),
                userDetail.getLastName()
        );
    }
}
