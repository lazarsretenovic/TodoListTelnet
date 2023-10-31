package com.TenetTodoList.TodoList.services.mappers;

import com.TenetTodoList.TodoList.domain.UserDetail;
import com.TenetTodoList.TodoList.dto.UserDetailDTORequest;
import com.TenetTodoList.TodoList.dto.UserDetailDTOResponse;
import com.TenetTodoList.TodoList.dto.UserDetailDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsMapper implements UserDetailsConverter {
    private static final Logger logger = LoggerFactory.getLogger(UserDetailsMapper.class);

    @Override
    public UserDetail convertFromDTO(UserDetailDto dto) {
        UserDetail userDetail = new UserDetail();
        try {
            userDetail.setId(dto.id());
            userDetail.setFirstName(dto.first_name());
            userDetail.setLastName(dto.last_name());
            userDetail.setEmail(dto.email());
            userDetail.setCity(dto.city());
        } catch (Exception e) {
            logger.error("Error converting UserDetailDto to UserDetail", e);
        }
        return userDetail;
    }
    @Override
    public UserDetailDto convertFromEntity(UserDetail entity) {
        try {
            return new UserDetailDto(
                    entity.getId(),
                    entity.getFirstName(),
                    entity.getLastName(),
                    entity.getEmail(),
                    entity.getCity()
            );
        } catch (Exception e) {
            logger.error("Error converting UserDetail to UserDetailDto", e);
            return null;
        }
    }

    @Override
    public UserDetailDTORequest convertFromEntityRequest(UserDetail entity) {
        try {
            return new UserDetailDTORequest(
                    entity.getId(),
                    entity.getFirstName(),
                    entity.getLastName(),
                    entity.getEmail(),
                    entity.getCity()
            );
        } catch (Exception e) {
            logger.error("Error converting UserDetail to UserDetailDTORequest", e);
            return null;
        }
    }

    @Override
    public UserDetailDTOResponse convertFromEntityResponse(UserDetail entity) {
        try {
            return new UserDetailDTOResponse(
                    entity.getFirstName(),
                    entity.getLastName()
            );
        } catch (Exception e) {
            logger.error("Error converting UserDetail to UserDetailDTOResponse", e);
            return null;
        }
    }
}