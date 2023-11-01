package com.TenetTodoList.ToDoList.services.mappers;

import com.TenetTodoList.ToDoList.domain.User;
import com.TenetTodoList.ToDoList.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    private final UserDetailsMapper userDetailsMapper;
    private static final Logger logger = LoggerFactory.getLogger(UserMapperImpl.class);

    public UserMapperImpl(UserDetailsMapper userDetailsMapper) {
        this.userDetailsMapper = userDetailsMapper;
    }
    @Override
    public User UserFromDtoToEntity(UserDTO dto) {
        try {
            User user = new User();
            user.setId(dto.id());
            user.setLoginname(dto.login_name());
            user.setRole(dto.role());
            UserDetailDto userDetailDto = dto.user_detail();
            user.setUserDetail(userDetailsMapper.UserDetailDtoTOEntity(userDetailDto));
            return user;
        } catch (Exception e) {
            logger.error("Error converting UserDTO to User", e);
            throw new RuntimeException("Error with converting", e);
        }
    }

    @Override
    public UserDTO UserFromEntityToDto(User entity) {
        try {
            UserDTO userDTO = new UserDTO(
                    entity.getId(),
                    entity.getLoginname(entity.getUsername()),
                    entity.getRole(),
                    userDetailsMapper.UserDetailFromEntityToDto(entity.getUserDetail())
            );
            UserDetailDto userDetailDto = userDetailsMapper.UserDetailFromEntityToDto(entity.getUserDetail());
            return userDTO;
        } catch (Exception e) {
            logger.error("Error converting User to UserDTO", e);
            throw new RuntimeException("Error with converting", e);
        }
    }

    @Override
    public UserDTOBaseInfo convertFromEntityBaseInfo(User entity) {
        try {
            UserDTOBaseInfo userDTOBaseInfo = new UserDTOBaseInfo(
                    entity.getId()
            );
            return userDTOBaseInfo;
        } catch (Exception e) {
            logger.error("Error converting User to UserDTONoDetails", e);
            throw new RuntimeException("Error with converting", e);
        }
    }
    @Override
    public UserDTOResponse UserDTOResponseFromEntityToDto(User entity) {
        try {
            return new UserDTOResponse(
                    entity.getId(),
                    entity.getUsername(),
                    userDetailsMapper.UserDetailResponseFromEntityToDto(entity.getUserDetail())
            );
        } catch (Exception e) {
            logger.error("Error converting User to UserDTOResponse", e);
            throw new RuntimeException("Error with converting", e);
        }
    }
    @Override
    public UserDTOWhoAmI convertFromEntityWhoAmI(User entity) {
        try {
            UserDTOWhoAmI userDtoWhoAmI = new UserDTOWhoAmI(
                    entity.getId(),
                    entity.getUsername(),
                    userDetailsMapper.UserDetailFromEntityToDto(entity.getUserDetail()),
                    entity.getRole(),
                    entity.isAccountNonExpired(),
                    entity.isAccountNonLocked(),
                    entity.isCredentialsNonExpired(),
                    entity.isEnabled()
            );
            return userDtoWhoAmI;
        } catch (Exception e) {
            logger.error("Error converting User to UserDTOWhoAmI", e);
            throw new RuntimeException("Error with converting", e);
        }
    }
}