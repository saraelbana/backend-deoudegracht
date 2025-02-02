package com.deoudegracht.deoudegracht.initializer;

import com.deoudegracht.deoudegracht.models.Employee;
import com.deoudegracht.deoudegracht.models.Role;
import com.deoudegracht.deoudegracht.models.User;
import com.deoudegracht.deoudegracht.services.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class InitialDataLoader implements CommandLineRunner {
    private final EmployeeService employeeService;
    private final PasswordEncoder passwordEncoder;

    public InitialDataLoader(EmployeeService employeeService, PasswordEncoder passwordEncoder) {
        this.employeeService = employeeService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (employeeService.getAllEmployees().isEmpty()) {
            User adminUser = new User(
                    "admin",
                    //passwordEncoder.encode("admin123"),
                    "admin123",
                    "Admin",
                    "User",
                    "admin@restaurant.com",
                    "1234567890",
                    Role.ADMIN
            );

            Employee admin = new Employee();
            admin.setUser(adminUser);
            admin.setRole(Role.ADMIN);
            employeeService.createEmployee(admin);
        }
    }
}