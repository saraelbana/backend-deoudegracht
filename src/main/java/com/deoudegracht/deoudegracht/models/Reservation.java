package com.deoudegracht.deoudegracht.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private LocalDate dateCreated;
    private LocalDate reservationDate;
    private LocalTime reservationTime;
    private int numberOfPersons;
    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;


    public Reservation() {
    }

}
