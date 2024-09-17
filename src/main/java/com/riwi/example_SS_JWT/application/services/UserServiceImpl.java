package com.riwi.example_SS_JWT.application.services;

import com.riwi.example_SS_JWT.application.dtos.reponse.AuthResponse;
import com.riwi.example_SS_JWT.application.dtos.reponse.UserResponse;
import com.riwi.example_SS_JWT.application.dtos.request.UserRequest;
import com.riwi.example_SS_JWT.application.mappers.UserMapper;
import com.riwi.example_SS_JWT.domain.entities.User;
import com.riwi.example_SS_JWT.domain.enums.Role;
import com.riwi.example_SS_JWT.domain.exceptions.InvalidCredentialsException;
import com.riwi.example_SS_JWT.domain.ports.service.IUserService;
import com.riwi.example_SS_JWT.infrastructure.helpers.JwtUtils;
import com.riwi.example_SS_JWT.infrastructure.persistence.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final JwtUtils jwtUtil;

    @Override
    public AuthResponse register(UserRequest request, Role role) {
        User userDB = userRepository.findByUsernameOrEmail(request.getUsername(),request.getEmail());

        if (userDB != null){
            throw new InvalidCredentialsException("Username register");
        }

        User user = User.builder()
                .name(request.getName())
                .username(request.getUsername())
                .email(request.getEmail())
                .password(this.passwordEncoder.encode(request.getPassword()))
                .role(role)
                .enabled(true)
                .build();

        user = this.userRepository.save(user);

        return AuthResponse.builder()
                .message(user.getRole() + " successfully authenticated")
                .token(this.jwtUtil.generateToken(user))
                .id(user.getId())
                .name(user.getName())
                .build();
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return this.userRepository.findAll()
                .stream().map(user -> UserMapper.INSTANCE.userToUserResponse(user)).toList();
    }
}
