package com.riwi.example_SS_JWT.application.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class UserRequest {
    @NotBlank(message = "name required")
    private String name;

    @NotBlank(message = "username required")
    private String username;

    @NotBlank(message = "email required")
    @Email(message = "invalid format")
    private String email;

    @NotBlank(message = "password required")
    // @Pattern() 8min char - 1M - 1m - 1n - 1e
    private String password;
}
