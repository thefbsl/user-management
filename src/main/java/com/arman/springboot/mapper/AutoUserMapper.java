package com.arman.springboot.mapper;

import com.arman.springboot.dto.UserDto;
import com.arman.springboot.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {
    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);
    UserDto mapToUserDto(User user);
    User mapToUser(UserDto userDto);

    // This is used when classes has different field names. In this case email in user, emailAddress in userDto
    // @Mapping(source = "email", target = "emailAddress")
    // UserDto mapToUserDto(User user);
}
