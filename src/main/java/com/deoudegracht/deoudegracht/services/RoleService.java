package com.deoudegracht.deoudegracht.services;

import com.deoudegracht.deoudegracht.dtos.RoleResponseDTO;
import com.deoudegracht.deoudegracht.models.RoleType;

import java.util.ArrayList;

public class RoleService {

    public RoleResponseDTO getAllRoleTypes() {
        ArrayList<String> roles = new ArrayList<>();
        for (RoleType role : RoleType.values()) {
            roles.add(role.name());
        }
        return  new RoleResponseDTO(roles);
    }
}
