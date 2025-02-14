package com.deoudegracht.deoudegracht.mappers;

import com.deoudegracht.deoudegracht.dtos.ReservationRequestDTO;
import com.deoudegracht.deoudegracht.dtos.ReservationResponseDTO;
import com.deoudegracht.deoudegracht.models.Reservation;

public class ReservationMapper {
    static public Reservation mapReservationRequestDTOToReservation(ReservationRequestDTO reservationRequestDTO){

        return new Reservation(reservationRequestDTO.getUsername(), reservationRequestDTO.getDateCreated(), reservationRequestDTO.getReservationDate(), reservationRequestDTO.getReservationTime(), reservationRequestDTO.getNumberOfPersons());
    }
    static public ReservationResponseDTO mapReservationToReservationResponseDTO(Reservation reservation) {
        return new ReservationResponseDTO(reservation.getID(), reservation.getUsername(), reservation.getReservationDate(), reservation.getReservationTime(), reservation.getDateCreated(), reservation.getNumberOfPersons());
    }
}
