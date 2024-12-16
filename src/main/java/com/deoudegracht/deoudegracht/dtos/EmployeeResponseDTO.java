package com.deoudegracht.deoudegracht.dtos;

import com.deoudegracht.deoudegracht.mappers.RoleMapper;
import com.deoudegracht.deoudegracht.models.User;

public class EmployeeResponseDTO {
    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String role;
    private String phone;

    public EmployeeResponseDTO(long id, String firstname, String lastname,
                               String email, String username, String role, String phone) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.username = username;
        this.role = role;
        this.phone = phone;
    }
    public EmployeeResponseDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
