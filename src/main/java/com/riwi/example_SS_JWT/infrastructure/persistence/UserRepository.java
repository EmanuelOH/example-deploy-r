package com.riwi.example_SS_JWT.infrastructure.persistence;

import com.riwi.example_SS_JWT.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsernameOrEmail(String username, String email);
}
