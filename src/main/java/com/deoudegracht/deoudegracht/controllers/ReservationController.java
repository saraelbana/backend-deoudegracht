package com.deoudegracht.deoudegracht.controllers;

import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/reservations")
public class ReservationController {
    public ReservationController() {
    }

    @GetMapping
    ResponseEntity<ReservationRequestDTO> getReservations() {
        return ResponseEntity.ok(new ReservationRequestDTO());
    }
}
