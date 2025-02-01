package com.deoudegracht.deoudegracht.dtos;

import com.deoudegracht.deoudegracht.models.Role;
import com.deoudegracht.deoudegracht.models.UserRole;

public class AutheticationResponseDTO {
    private String token;
    private String username;
    private Role userRole;

    public AutheticationResponseDTO(String token, String username, Role userRole) {
        this.token = token;
        this.username = username;
        this.userRole = userRole;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }
}
