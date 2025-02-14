package com.deoudegracht.deoudegracht.controllers;

import com.deoudegracht.deoudegracht.services.EmployeeService;
import com.deoudegracht.deoudegracht.services.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RoleController {
    private final RoleService roleService;

    public RoleController() {
        this.roleService = new RoleService();
    }

    @GetMapping
    ResponseEntity<?> getAllRoles() {
        try {

            return ResponseEntity.ok().body(roleService.getAllRoleTypes());
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }
}
