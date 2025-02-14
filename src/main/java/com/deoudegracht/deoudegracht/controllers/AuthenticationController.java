package com.deoudegracht.deoudegracht.controllers;

import com.deoudegracht.deoudegracht.dtos.AuthenticationRequestDTO;
import com.deoudegracht.deoudegracht.dtos.AutheticationResponseDTO;
import com.deoudegracht.deoudegracht.dtos.GuestRequestDTO;
import com.deoudegracht.deoudegracht.dtos.GuestResponseDTO;
import com.deoudegracht.deoudegracht.mappers.GuestMapper;
import com.deoudegracht.deoudegracht.services.AuthenticationService;
import com.deoudegracht.deoudegracht.services.GuestService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthenticationService authService;
    private final GuestService guestService;
    public AuthenticationController(AuthenticationService authService, GuestService guestService) {
        this.authService = authService;
        this.guestService = guestService;
    }
    @PostMapping("/login")
    public ResponseEntity<AutheticationResponseDTO> login(@RequestBody AuthenticationRequestDTO request) {
        try {
            return ResponseEntity.ok(authService.authenticate(request));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody GuestRequestDTO guestRequestDTO) {
        try{
            guestRequestDTO.setUsername(guestRequestDTO.getUsername().toLowerCase());
            GuestResponseDTO newCreatedGuestDto = guestService.createGuest(GuestMapper.mapGuestRequestDTOToGuest(guestRequestDTO));


            URI uri = URI.create(ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/" + newCreatedGuestDto.getUsername())
                    .toUriString());


            return ResponseEntity.created(uri).body(newCreatedGuestDto);
        }
        catch (Exception e) {

            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }

}