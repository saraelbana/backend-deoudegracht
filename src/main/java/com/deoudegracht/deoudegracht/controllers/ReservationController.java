package com.deoudegracht.deoudegracht.controllers;

import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/reservations")
public class ReservationController {
    public ReservationController() {
    }

    @GetMapping
    ResponseEntity<ReservationResponseDTO> getReservations() {
        return ResponseEntity.ok(new ReservationResponseDTO());
    }
    @GetMapping("/{id}")
    ResponseEntity<ReservationResponseDTO> getReservation(@RequestParam String id) {
        return ResponseEntity.ok(new ReservationResponseDTO());
    }
    @PostMapping()
    ResponseEntity<ReservationResponseDTO> createReservation(@RequestBody ReservationRequestDTO reservationRequestDTO) {
        return ResponseEntity.ok(new ReservationResponseDTO());
    }
    @PutMapping("/{id}")
    ResponseEntity<ReservationResponseDTO> updateReservation(@RequestParam String id, @RequestBody ReservationRequestDTO reservationRequestDTO) {
        return ResponseEntity.ok(new ReservationResponseDTO());
    }
    @DeleteMapping("/{id}")
    ResponseEntity<ReservationResponseDTO> deleteReservation(@RequestParam String id) {
        return ResponseEntity.ok(new ReservationResponseDTO());
    }
}
