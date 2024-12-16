package com.deoudegracht.deoudegracht.services;

import com.deoudegracht.deoudegracht.dtos.RoleResponseDTO;
import com.deoudegracht.deoudegracht.models.Role;

import java.util.ArrayList;

public class RoleService {

    public RoleResponseDTO getAllRoleTypes() {
        ArrayList<String> roles = new ArrayList<>();
        for (Role role : Role.values()) {
            roles.add(role.name());
        }
        return  new RoleResponseDTO(roles);
    }
}
