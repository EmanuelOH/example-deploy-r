package com.riwi.example_SS_JWT.application.dtos.reponse;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@SuperBuilder
public class UserResponse {
    private Long id;
    private String name;
}
