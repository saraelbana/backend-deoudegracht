package com.deoudegracht.deoudegracht.dtos;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import org.jetbrains.annotations.NotNull;

public class EmployeeRequestDTO {
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    @NotNull
    @Email(message = "Please enter a valid email")
    private String email = "not provided";
    @NotNull
    private String username;
    @NotNull
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;
    private String role = "EMPLOYEE";
    private String phone = "not provided";
    public EmployeeRequestDTO() {
    }
    public EmployeeRequestDTO(@NotNull String firstname, @NotNull String lastname, String email, @NotNull String username, @NotNull String password, String role, String phone) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
        this.phone = phone;

        System.out.println("HELLO FROM EMPLOYEE REQUEST DTO EMAIL: " + this.email + ", ROLE: " + this.role + ", PHONE: " + this.phone);
        System.out.println("HELLO FROM EMPLOYEE REQUEST DTO ROLE is " + role);
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

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname + " " + email + " " + phone + " " + username + " " + password + " " + role;
    }
}
