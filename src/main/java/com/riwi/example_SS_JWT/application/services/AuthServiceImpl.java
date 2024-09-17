package com.riwi.example_SS_JWT.application.services;

import com.riwi.example_SS_JWT.application.dtos.reponse.AuthResponse;
import com.riwi.example_SS_JWT.application.dtos.request.AuthRequest;
import com.riwi.example_SS_JWT.domain.entities.User;
import com.riwi.example_SS_JWT.domain.exceptions.InvalidCredentialsException;
import com.riwi.example_SS_JWT.domain.ports.service.IAuthService;
import com.riwi.example_SS_JWT.infrastructure.helpers.JwtUtils;
import com.riwi.example_SS_JWT.infrastructure.persistence.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private final JwtUtils jwtUtil;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse login(AuthRequest request) {

        User user = (User) userDetailsService.loadUserByUsername(request.getIdentifier());

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new InvalidCredentialsException("Invalid credentials");
        }

        authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(request.getIdentifier(), request.getPassword()));

        return AuthResponse.builder()
                .message(user.getRole() + " successfully authenticated")
                .token(this.jwtUtil.generateToken(user))
                .build();
    }
}
