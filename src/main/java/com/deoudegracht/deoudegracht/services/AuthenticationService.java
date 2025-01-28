package com.deoudegracht.deoudegracht.services;

import com.deoudegracht.deoudegracht.dtos.AuthenticationRequestDTO;
import com.deoudegracht.deoudegracht.dtos.AutheticationResponseDTO;
import com.deoudegracht.deoudegracht.models.Role;
import com.deoudegracht.deoudegracht.security.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthenticationService(UserDetailsService userDetailsService,
                               PasswordEncoder passwordEncoder,
                               JwtService jwtService) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    } 

    public AutheticationResponseDTO authenticate(AuthenticationRequestDTO request) {
        UserDetails userDetails;
        try {
            userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        } catch (UsernameNotFoundException e) {
            logger.debug("User not found: {}", request.getUsername());
            throw new BadCredentialsException("Invalid credentials");
        }

        if (!passwordEncoder.matches(request.getPassword(), userDetails.getPassword())) {
            logger.debug("Invalid password for user: {}", request.getUsername());
            throw new BadCredentialsException("Invalid credentials");
        }

        String token = jwtService.generateToken(userDetails);
        Role userRole = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .map(Role::valueOf)
                .findFirst()
                .orElse(Role.GUEST);

        logger.debug("Generated token for user {} with role {}", request.getUsername(), userRole);
        return new AutheticationResponseDTO(token, request.getUsername(), userRole);
    }
}