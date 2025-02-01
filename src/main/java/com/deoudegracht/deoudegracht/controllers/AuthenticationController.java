package com.deoudegracht.deoudegracht.controllers;

import com.deoudegracht.deoudegracht.dtos.AuthenticationRequestDTO;
import com.deoudegracht.deoudegracht.dtos.AutheticationResponseDTO;
import com.deoudegracht.deoudegracht.services.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthenticationService authService;
    public AuthenticationController(AuthenticationService authService) {
        this.authService = authService;
    }
    @PostMapping("/login")
    public ResponseEntity<AutheticationResponseDTO> login(@RequestBody AuthenticationRequestDTO request) {
        try {
            return ResponseEntity.ok(authService.authenticate(request));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}