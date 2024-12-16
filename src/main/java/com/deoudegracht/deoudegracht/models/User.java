package com.deoudegracht.deoudegracht.models;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(nullable = false, unique = true)
    @NotNull(message = "Username is required")
    private String username;
    @Column(nullable = false)
    @NotNull(message = "password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    @Column(name = "firstname")
    @NotNull
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Firstname should only contain letters") // this pater annoctation require another
    //annotation to work properly which is the @Valid annotation
    private String firstname;
    @Column(name = "lastname")
    @NotNull
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Lastname should only contain letters")
    private String lastname;

    @Email(message = "Please enter a valid email format")
    private String email;
    //a REgExp to validate the phone number let's set it later
    // @Pattern(regexp = "^\\+?[1-9][0-9]{7,14}$", message = "Please enter a valid phone number")
    private String phone;


   public User() {}
    public User(String username, String password, String firstname, String lastname, String email, String phone) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
