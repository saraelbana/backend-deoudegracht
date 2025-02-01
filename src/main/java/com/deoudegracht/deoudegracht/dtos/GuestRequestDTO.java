package com.deoudegracht.deoudegracht.dtos;

import com.deoudegracht.deoudegracht.models.Reservation;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class GuestRequestDTO {
    @NotNull
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Firstname should only contain letters")
    private String firstname;
    @NotNull
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Lastname should only contain letters")
    private String lastname;
    @NotNull
    @Email(message = "Please enter a valid email format")
    private String email = "not provided";
    @NotNull
    private String username;
    @NotNull
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;
    private String phone = "not provided";

    private List<Reservation> reservations = new ArrayList<>();
    public GuestRequestDTO(@NotNull String firstname, @NotNull String lastname, String email, @NotNull String username, @NotNull String password, String phone) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username.toLowerCase();
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname + " " + email + " " + phone + " " + username;
    }


}
