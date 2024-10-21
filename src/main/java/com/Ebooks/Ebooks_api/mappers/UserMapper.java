package com.Ebooks.Ebooks_api.mappers;

import com.Ebooks.Ebooks_api.Dto.Input.CreateUserDto;
import com.Ebooks.Ebooks_api.Dto.Output.UserDto;
import com.Ebooks.Ebooks_api.Entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(CreateUserDto dto);

    @Mapping(target = "roles", ignore = true)
    UserDto toOutputDto(User user);
}
