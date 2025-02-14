package com.deoudegracht.deoudegracht.controllers;

import com.deoudegracht.deoudegracht.dtos.ReservationRequestDTO;
import com.deoudegracht.deoudegracht.dtos.ReservationResponseDTO;
import com.deoudegracht.deoudegracht.mappers.ReservationMapper;
import com.deoudegracht.deoudegracht.services.ReservationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Controller
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    @PostMapping()
    ResponseEntity<?> createReservation(@RequestBody ReservationRequestDTO reservationRequestDTO) {
        try {

            ReservationResponseDTO newCreatedReservationDto = reservationService.createReservation(ReservationMapper.mapReservationRequestDTOToReservation(reservationRequestDTO));


            URI uri = URI.create(ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/" + newCreatedReservationDto.getID())
                    .toUriString());


            return ResponseEntity.created(uri).body(newCreatedReservationDto);
        }
        catch (Exception e) {

            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }
    @GetMapping
    ResponseEntity<?> getReservations() {
        try {
            return ResponseEntity.ok().body(reservationService.getAllReservations());

        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }
    @GetMapping("/{username}")
    ResponseEntity<?> getReservation(@PathVariable String username) {
        try{
            return ResponseEntity.ok().body(reservationService.getReservationByUsername(username.toLowerCase()));
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping
    ResponseEntity<?> deleteReservation(@RequestParam long id) {
        try {
            reservationService.deleteReservation(id);
            return ResponseEntity.ok().body("Reservation deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }
}
