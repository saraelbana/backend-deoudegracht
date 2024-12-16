package com.deoudegracht.deoudegracht.repositories;

import com.deoudegracht.deoudegracht.models.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    Optional<Guest> findByUser_Username(String username);
}
