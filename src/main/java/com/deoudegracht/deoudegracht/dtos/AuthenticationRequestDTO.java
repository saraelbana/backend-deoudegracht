package com.deoudegracht.deoudegracht.dtos;

public class AuthenticationRequestDTO {
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;

    public AuthenticationRequestDTO( String firstname, String lastname, String email, String username, String password) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }
    public AuthenticationRequestDTO(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public AuthenticationRequestDTO() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
