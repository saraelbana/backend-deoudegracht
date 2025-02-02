package com.deoudegracht.deoudegracht.servicesTests;

import com.deoudegracht.deoudegracht.DeOudegrachtApplication;
import com.deoudegracht.deoudegracht.dtos.EmployeeResponseDTO;
import com.deoudegracht.deoudegracht.models.Employee;
import com.deoudegracht.deoudegracht.models.Role;
import com.deoudegracht.deoudegracht.models.User;
import com.deoudegracht.deoudegracht.repositories.EmployeeRepository;
import com.deoudegracht.deoudegracht.services.EmployeeService;
import com.deoudegracht.deoudegracht.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @Mock
    private EmployeeRepository employeeRepository;
    
    @Mock
    private UserService userService;
    
    @Mock
    private PasswordEncoder passwordEncoder;
    
    @InjectMocks
    private EmployeeService employeeService;

    private Employee createTestEmployee(String username) {
        User user = new User();
        user.setUsername(username);
        user.setFirstname("John");
        user.setLastname("Doe");
        user.setEmail("john@example.com");

        Employee employee = new Employee();
        employee.setUser(user);
        employee.setRole(Role.EMPLOYEE);
        return employee;
    }
    @Test
    public void testCreateEmployee() {
        //given
        String username = "testcreateusername";
        Employee employee = new Employee();
        employee.setUser(new User(username, "testingPassword", "firstname", "lastname", "test@test.com", "phone"));
        employee.setRole(Role.EMPLOYEE);

        // when
        Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
        EmployeeResponseDTO createdEmployee = employeeService.createEmployee(employee);

        //then
        assertEquals(employee.getUser().getUsername(), createdEmployee.getUsername());
        assertEquals(employee.getUser().getFirstname(), createdEmployee.getFirstname());
        assertEquals(employee.getUser().getLastname(), createdEmployee.getLastname());
        assertEquals(employee.getUser().getEmail(), createdEmployee.getEmail());
        assertEquals(employee.getUser().getPhone(), createdEmployee.getPhone());
        assertEquals(employee.getRole().toString(), createdEmployee.getRole());
    }
    @Test
    void createEmployee_Success() {
        // Arrange
        User user = new User();
        user.setUsername("john.doe");
        user.setPassword("password123");
        user.setFirstname("John");
        user.setLastname("Doe");
        user.setEmail("john@example.com");

        Employee employee = new Employee();
        employee.setUser(user);
        employee.setRole(Role.EMPLOYEE);

        when(userService.findByUsername("john.doe")).thenReturn(Optional.empty());
        when(passwordEncoder.encode("password123")).thenReturn("encodedPassword");
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        // Act
        EmployeeResponseDTO result = employeeService.createEmployee(employee);

        // Assert
        assertNotNull(result);
        assertEquals("john.doe", result.getUsername());
        assertEquals("John", result.getFirstname());
    }
    @Test
    void getAllEmployees_Success() {
        // Arrange
        List<Employee> employees = Arrays.asList(
                createTestEmployee("john.doe"),
                createTestEmployee("jane.doe")
        );
        when(employeeRepository.findAll()).thenReturn(employees);

        // Act
        List<EmployeeResponseDTO> result = employeeService.getAllEmployees();

        // Assert
        assertNotNull(result);
    }

    @Test
    void deleteEmployee_NotFound() {
        // Arrange
        when(employeeRepository.findByUser_Username("notfound")).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(EntityNotFoundException.class, () -> {
            employeeService.deleteEmployee("notfound");
        });
    }

    @Test
    public void testGetEmployeeByUsername() {
        // given
        String username = "testgetusername";
        String firstName = "John";
        String lastName = "Doe";
        String email = "john.doe@test.com";
        String phone = "1234567890";
        Role role = Role.EMPLOYEE;

        User user = new User(username, "testingPassword", firstName, lastName, email, phone);
        Employee employee = new Employee();
        employee.setUser(user);
        employee.setRole(role);

        // when
        when(employeeRepository.findByUser_Username(username)).thenReturn(Optional.of(employee));
        
        // then
        EmployeeResponseDTO found = employeeService.getEmployeeByUsername(username);
        
        // verify
        assertNotNull(found, "Employee response should not be null");
        assertEquals(username, found.getUsername(), "Username should match");
        assertEquals(firstName, found.getFirstname(), "First name should match");
        assertEquals(lastName, found.getLastname(), "Last name should match");
        assertEquals(email, found.getEmail(), "Email should match");
        assertEquals(phone, found.getPhone(), "Phone should match");
    }
}
