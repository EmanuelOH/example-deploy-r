package com.riwi.example_SS_JWT.application.services;

import com.riwi.example_SS_JWT.application.dtos.reponse.AuthResponse;
import com.riwi.example_SS_JWT.application.dtos.request.AuthRequest;
import com.riwi.example_SS_JWT.domain.entities.User;
import com.riwi.example_SS_JWT.infrastructure.persistence.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String identifier) throws UsernameNotFoundException {

        User user = userRepository.findByUsernameOrEmail(identifier, identifier);

        if (user == null){
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

}
