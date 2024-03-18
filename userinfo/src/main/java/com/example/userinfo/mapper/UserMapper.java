package com.example.userinfo.mapper;

import com.example.userinfo.dto.UserDTO;
import com.example.userinfo.entity.UserInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserInfo mapUserDTOToUser(UserDTO userDTO);
    UserDTO mapUserToUserDTO(UserInfo user);

}
