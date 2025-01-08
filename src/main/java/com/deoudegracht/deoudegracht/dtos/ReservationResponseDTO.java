package com.deoudegracht.deoudegracht.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationResponseDTO {
    public long ID;
    public String username;
    public LocalDate reservationDate;
    public LocalTime reservationTime;
    public LocalDate dateCreated;
    public int numberOfPersons;

    public ReservationResponseDTO(long ID, String username, LocalDate reservationDate, LocalTime reservationTime, LocalDate dateCreated, int numberOfPersons) {
        this.ID = ID;
        this.username = username;
        this.reservationDate = reservationDate;
        this.reservationTime = reservationTime;
        this.dateCreated = dateCreated;
        this.numberOfPersons = numberOfPersons;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public LocalTime getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }
}
