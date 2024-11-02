package com.deoudegracht.deoudegracht.dtos;

import java.util.ArrayList;

public class RoleResponseDTO {
    private int roleCounter;
    private ArrayList<String> roles;


    public RoleResponseDTO(ArrayList<String> roles) {
        this.roles = roles;
        this.roleCounter = roles.size();
    }
    public ArrayList<String> getAllRoles() {
        return roles;
    }

}
