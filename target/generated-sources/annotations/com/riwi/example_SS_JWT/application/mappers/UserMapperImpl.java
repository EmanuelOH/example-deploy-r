package com.riwi.example_SS_JWT.application.mappers;

import com.riwi.example_SS_JWT.application.dtos.reponse.UserResponse;
import com.riwi.example_SS_JWT.domain.entities.User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-16T20:55:53-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserResponse userToUserResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponse.UserResponseBuilder<?, ?> userResponse = UserResponse.builder();

        userResponse.id( user.getId() );
        userResponse.name( user.getName() );

        return userResponse.build();
    }
}
