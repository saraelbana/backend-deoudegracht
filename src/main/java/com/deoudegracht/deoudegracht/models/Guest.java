package com.deoudegracht.deoudegracht.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    @JoinColumn(name = "user_username", referencedColumnName = "username")
    User user;

    @OneToMany(mappedBy = "guest")
    private List<Reservation> reservations = new ArrayList<>();

    public Guest() {
    }
    public Guest(String firstname, String lastname, String email, String username, String password, String phone)
    {
        this.user = new User(username, password, firstname, lastname, email, phone, Role.GUEST);
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }
}
