package com.deoudegracht.deoudegracht.controllers;

import com.deoudegracht.deoudegracht.dtos.EmployeeRequestDTO;
import com.deoudegracht.deoudegracht.dtos.EmployeeResponseDTO;
import com.deoudegracht.deoudegracht.dtos.GuestRequestDTO;
import com.deoudegracht.deoudegracht.dtos.GuestResponseDTO;
import com.deoudegracht.deoudegracht.mappers.EmployeeMapper;
import com.deoudegracht.deoudegracht.mappers.GuestMapper;
import com.deoudegracht.deoudegracht.services.GuestService;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/guests")
public class GuestController {
    private final GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @PostMapping
    ResponseEntity<?> createEmployee(@Valid @RequestBody GuestRequestDTO guestRequestDTO){
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
    @GetMapping
    ResponseEntity<?>/*<List<EmployeeResponseDTO>>*/ getAllGuests() {
        try {
            return ResponseEntity.ok().body(guestService.getAllGuests());

        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }
    @GetMapping("/{username}")
    ResponseEntity<GuestResponseDTO> getGuestByUsername(@PathVariable String username /*@RequestParam String username*/) {
        username = username.toLowerCase();
        try{
            return ResponseEntity.ok().body(guestService.getGuestByUsername(username.toLowerCase()));
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping
    ResponseEntity<?> updateGuest(@Valid @RequestBody GuestRequestDTO guestRequestDTO) {
        try {
            return ResponseEntity.ok().body(
                    guestService.updateGuest(
                            GuestMapper.mapGuestRequestDTOToGuest(
                                    guestRequestDTO)
                    ));
        } catch (Exception e) {

            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }
    @DeleteMapping
    ResponseEntity<?> deleteGuest(@RequestParam String username) {
        try {
            guestService.deleteGuest(username.toLowerCase());
            return ResponseEntity.ok().body("Guest deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }

}
