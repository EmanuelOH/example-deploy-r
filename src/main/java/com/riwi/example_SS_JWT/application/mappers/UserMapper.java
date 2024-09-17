package com.riwi.example_SS_JWT.application.mappers;

import com.riwi.example_SS_JWT.application.dtos.reponse.UserResponse;
import com.riwi.example_SS_JWT.domain.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    UserResponse userToUserResponse(User user);
}
