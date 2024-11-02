package com.deoudegracht.deoudegracht.dtos;

public class LoginResponseDTO {
    private String username;
    private String password;
    private long id;

    public LoginResponseDTO(String username, String password, long id) {
        this.username = username;
        this.password = password;
        this.id = id;
    }
    public long getId() {
        return id;
    }
    public LoginResponseDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
