package com.deoudegracht.deoudegracht.servicesTests;

import com.deoudegracht.deoudegracht.dtos.RoleResponseDTO;
import com.deoudegracht.deoudegracht.services.RoleService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoleServiceTest {
    @Test
    public void testGetAllRoleTypes() {
        RoleService service = new RoleService();
        RoleResponseDTO response = service.getAllRoleTypes();


        assertEquals(5, response.getAllRoles().size());
        assertEquals("EMPLOYEE", response.getAllRoles().get(0));
        assertEquals("ADMIN", response.getAllRoles().get(1));
        assertEquals("CHEF", response.getAllRoles().get(2));
        assertEquals("WAITER", response.getAllRoles().get(3));
        assertEquals("GUEST", response.getAllRoles().get(4));
    }
}
