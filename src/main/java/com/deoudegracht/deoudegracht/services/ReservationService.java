package com.deoudegracht.deoudegracht.services;

import com.deoudegracht.deoudegracht.models.Reservation;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    public ReservationService() {
    }

    public Reservation getReservations() {
        return new Reservation();
    }
}