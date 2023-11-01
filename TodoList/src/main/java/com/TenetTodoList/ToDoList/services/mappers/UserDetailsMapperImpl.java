package com.TenetTodoList.ToDoList.services.mappers;

import com.TenetTodoList.ToDoList.domain.UserDetail;
import com.TenetTodoList.ToDoList.dto.UserDetailDTORequest;
import com.TenetTodoList.ToDoList.dto.UserDetailDTOResponse;
import com.TenetTodoList.ToDoList.dto.UserDetailDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsMapperImpl implements UserDetailsMapper {
    private static final Logger logger = LoggerFactory.getLogger(UserDetailsMapperImpl.class);

    @Override
    public UserDetail UserDetailDtoTOEntity(UserDetailDto dto) {
        try {
        UserDetail userDetail = new UserDetail();
            userDetail.setId(dto.id());
            userDetail.setFirstName(dto.first_name());
            userDetail.setLastName(dto.last_name());
            userDetail.setEmail(dto.email());
            userDetail.setCity(dto.city());
            return userDetail;
        } catch (Exception e) {
            logger.error("Error converting UserDetailDto to UserDetail", e);
            throw new RuntimeException("Error with converting");
        }
    }
    @Override
    public UserDetailDto UserDetailFromEntityToDto(UserDetail entity) {
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
            throw new RuntimeException("Error with converting", e);
        }
    }
    @Override
    public UserDetailDTORequest UserDetailRequestFromEntityToDto(UserDetail entity) {
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
            throw new RuntimeException("Error with converting", e);
        }
    }
    @Override
    public UserDetailDTOResponse UserDetailResponseFromEntityToDto(UserDetail entity) {
        try {
            return new UserDetailDTOResponse(
                    entity.getFirstName(),
                    entity.getLastName()
            );
        } catch (Exception e) {
            logger.error("Error converting UserDetail to UserDetailDTOResponse", e);
            throw new RuntimeException("Error with converting", e);
        }
    }
}