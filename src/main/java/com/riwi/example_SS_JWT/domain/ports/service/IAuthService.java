package com.riwi.example_SS_JWT.domain.ports.service;

import com.riwi.example_SS_JWT.application.dtos.reponse.AuthResponse;
import com.riwi.example_SS_JWT.application.dtos.request.AuthRequest;

public interface IAuthService {
    public AuthResponse login(AuthRequest request);
}
