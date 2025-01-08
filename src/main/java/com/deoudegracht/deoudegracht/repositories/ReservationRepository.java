package com.deoudegracht.deoudegracht.repositories;

import com.deoudegracht.deoudegracht.models.Employee;
import com.deoudegracht.deoudegracht.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Optional<Reservation> findByUser_Username(String username);
}
