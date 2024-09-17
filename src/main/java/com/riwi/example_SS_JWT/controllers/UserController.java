package com.riwi.example_SS_JWT.controllers;

import com.riwi.example_SS_JWT.application.dtos.reponse.AuthResponse;
import com.riwi.example_SS_JWT.application.dtos.reponse.UserResponse;
import com.riwi.example_SS_JWT.application.dtos.request.UserRequest;
import com.riwi.example_SS_JWT.domain.enums.Role;
import com.riwi.example_SS_JWT.domain.ports.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@AllArgsConstructor
@Tag(name = "User", description = "Manages user-related requests.")
public class UserController {

    @Autowired
    private final IUserService userService;

    @SecurityRequirement(name = "bearerAuth")
    @PostMapping("admin/register")
    @Operation(
            summary = "Create an admin.",
            description = "Provides the user data to create it and the token to validate the permissions.")
    public ResponseEntity<AuthResponse> registerAdmin(
            @Validated @RequestBody UserRequest request) {
        return ResponseEntity.ok(this.userService.register(request, Role.ADMIN));
    }

    @PostMapping("register")
    @Operation(
            summary = "Create a customer.",
            description = "Provides the user's data to create the client.")
    public ResponseEntity<AuthResponse> registerCustomer(
            @Validated @RequestBody UserRequest request) {
        return ResponseEntity.ok(this.userService.register(request, Role.CLIENT));
    }

    @SecurityRequirement(name = "bearerAuth")
    @GetMapping
    @Operation(
            summary = "List all users.",
            description = "Provide the token to validate the permissions and obtain the list of users.")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

}
