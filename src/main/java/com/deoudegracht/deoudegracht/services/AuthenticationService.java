package com.deoudegracht.deoudegracht.services;

import com.deoudegracht.deoudegracht.dtos.AuthenticationRequestDTO;
import com.deoudegracht.deoudegracht.dtos.AutheticationResponseDTO;
import com.deoudegracht.deoudegracht.exceptions.NotFoundException;
import com.deoudegracht.deoudegracht.models.Role;
import com.deoudegracht.deoudegracht.models.User;
import com.deoudegracht.deoudegracht.repositories.UserRepository;
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
    private UserRepository userRepository;

    public AuthenticationService(UserDetailsService userDetailsService,
                               PasswordEncoder passwordEncoder,
                               JwtService jwtService, UserRepository userRepository) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    } 

    public AutheticationResponseDTO authenticate(AuthenticationRequestDTO request) {
        UserDetails userDetails;
        User user;
        try {
            userDetails = userDetailsService.loadUserByUsername(request.getUsername());
            user = userRepository.findByUsername(request.getUsername()).get();
        } catch (Exception e) {
            logger.debug("User not found: {}", request.getUsername());
            throw new RuntimeException("User not found");
        }

        if (!passwordEncoder.matches(request.getPassword(), userDetails.getPassword())) {
            logger.debug("Invalid password for user: {}", request.getUsername());
            throw new RuntimeException("User not found");
        }

        String token = jwtService.generateToken(userDetails);
        Role userRole = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .map(Role::valueOf)
                .findFirst()
                .orElse(Role.GUEST);

        logger.debug("Generated token for user {} with role {}", request.getUsername(), userRole);
        return new AutheticationResponseDTO(token, request.getUsername(), userRole, user.getFirstname());
    }

    public AutheticationResponseDTO register(AuthenticationRequestDTO request) {

        User newUser = new User();
        newUser.setUsername(request.getUsername());
        newUser.setFirstname(request.getFirstname());
        newUser.setLastname(request.getLastname());
        newUser.setEmail(request.getEmail());
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        newUser.setUserRole(Role.GUEST);

        userRepository.save(newUser);
        UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
                .username(request.getUsername())
                .password(newUser.getPassword())
                .roles(Role.GUEST.name())
                .build();
        String token = jwtService.generateToken(userDetails);
        return new AutheticationResponseDTO(token, request.getUsername(), Role.GUEST, request.getFirstname());
    }
}