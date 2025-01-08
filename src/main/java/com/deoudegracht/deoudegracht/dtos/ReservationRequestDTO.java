package com.deoudegracht.deoudegracht.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationRequestDTO {
    @NotNull
    private String username;
    @NotNull
    private LocalDate reservationDate;
    @NotNull
    private LocalTime reservationTime;
    @NotNull
    private LocalDate dateCreated;
    @NotNull
    @Min(1)
    @Max(15)
    //Minimum number of persons is 1 and maximum is 15
    private int numberOfPersons;

    public ReservationRequestDTO(@NotNull String username, @NotNull LocalDate reservationDate, @NotNull LocalDate dateCreated, @NotNull @Min(1) @Max(15) int numberOfPersons) {
        this.username = username;
        this.reservationDate = reservationDate;
        this.dateCreated = dateCreated;
        this.numberOfPersons = numberOfPersons;
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

    public LocalTime getReservationTime() {return reservationTime;}

    public void setReservationTime(LocalTime reservationTime) {this.reservationTime = reservationTime;}
}
