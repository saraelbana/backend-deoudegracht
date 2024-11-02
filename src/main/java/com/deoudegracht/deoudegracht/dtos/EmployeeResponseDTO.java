package com.deoudegracht.deoudegracht.dtos;

import com.deoudegracht.deoudegracht.mappers.RoleMapper;
import com.deoudegracht.deoudegracht.models.User;

public class EmployeeResponseDTO {
    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private User user;


    public EmployeeResponseDTO(long id, String firstname, String lastname, String email, String phone, String username, String role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.user = new User(username,role);
        this.id = id;

    }
    public EmployeeResponseDTO() {
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
        return user.getUsername();
    }

    public void setUsername(String username) {
        this.user.setUsername(username);
    }
    public long getId() {
        return this.id;
    }
}
