package com.deoudegracht.deoudegracht.dtos;

import com.deoudegracht.deoudegracht.models.Role;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.jetbrains.annotations.NotNull;

public class EmployeeRequestDTO {
    @NotNull
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Firstname should only contain letters")
    private String firstname;
    @NotNull
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Lastname should only contain letters")
    private String lastname;
    @NotNull
    @Email(message = "Please enter a valid email format")
    private String email = "not provided";
    @jakarta.validation.constraints.NotNull(message = "Username is required")
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
        this.username = username.toLowerCase();
        this.password = password;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        try {
            Role.valueOf(role);
            this.role = role;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("This role doesn't exist: " + role);
        }
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
