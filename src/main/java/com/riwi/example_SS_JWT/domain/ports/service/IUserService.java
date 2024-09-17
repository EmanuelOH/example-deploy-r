package com.riwi.example_SS_JWT.domain.ports.service;

import com.riwi.example_SS_JWT.application.dtos.reponse.AuthResponse;
import com.riwi.example_SS_JWT.application.dtos.reponse.UserResponse;
import com.riwi.example_SS_JWT.application.dtos.request.UserRequest;
import com.riwi.example_SS_JWT.domain.enums.Role;

import java.util.List;

public interface IUserService {
    public AuthResponse register(UserRequest request, Role role);
    public List<UserResponse> getAllUsers();
}
