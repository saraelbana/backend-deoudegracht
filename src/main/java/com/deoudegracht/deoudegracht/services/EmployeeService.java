package com.deoudegracht.deoudegracht.services;

import com.deoudegracht.deoudegracht.dtos.EmployeeResponseDTO;
import com.deoudegracht.deoudegracht.mappers.EmployeeMapper;
import com.deoudegracht.deoudegracht.models.Employee;
import com.deoudegracht.deoudegracht.repositories.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public EmployeeService(EmployeeRepository employeeRepository, UserService userService, PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    public EmployeeResponseDTO createEmployee(Employee employee) {
        String username = employee.getUser().getUsername();

        String encryptedPassword = passwordEncoder.encode(employee.getUser().getPassword());
        if (userService.findByUsername(username).isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        try {
            employee.getUser().setPassword(encryptedPassword);
            Employee savedEmployee = employeeRepository.save(employee);
            return EmployeeMapper.mapEmployeeToEmployeeResponseDTO(savedEmployee);
        }
        catch (Exception e) {
            throw new RuntimeException("Failed to create employee: " + e.getMessage());
        }
    }
    public List<EmployeeResponseDTO> getAllEmployees() {
        try {
            List <EmployeeResponseDTO> employeesResponseDtoList;
            List <Employee> employeesList = employeeRepository.findAll();
            if(employeesList.isEmpty()) {
                return Collections.emptyList();
            }
            else {
                employeesResponseDtoList = new ArrayList<>();
                for (Employee employee : employeesList) {
                    employeesResponseDtoList.add(EmployeeMapper.mapEmployeeToEmployeeResponseDTO(employee));

                }
                return employeesResponseDtoList;
            }
        }catch (Exception e) {
            throw new RuntimeException("No Employees found");
        }
    }
    public EmployeeResponseDTO getEmployeeByUsername(String username) {
        try {
            
            Optional<Employee> employee = employeeRepository.findByUser_Username(username);
            if (employee.isEmpty()) {
                throw new RuntimeException("Employee not found");
            }


            return EmployeeMapper.mapEmployeeToEmployeeResponseDTO(employee.get());
        } catch (Exception e) {
            throw new RuntimeException("Employee not found");
        }
    }

    public EmployeeResponseDTO updateEmployee(Employee newDataEmployee) {
        try {
            Optional<Employee> existingEmployeeOptional = employeeRepository.findByUser_Username(newDataEmployee.getUser().getUsername());

            if (!existingEmployeeOptional.isPresent()) {
                throw new RuntimeException("Employee not found");
            }


            Employee existingEmployee = existingEmployeeOptional.get();
            existingEmployee.getUser().setFirstname(newDataEmployee.getUser().getFirstname());
            existingEmployee.getUser().setLastname(newDataEmployee.getUser().getLastname());
            existingEmployee.getUser().setEmail(newDataEmployee.getUser().getEmail());
            existingEmployee.getUser().setPhone(newDataEmployee.getUser().getPhone());
            existingEmployee.setRole(newDataEmployee.getRole());

            Employee updatedEmployee = employeeRepository.save(existingEmployee);

            return EmployeeMapper.mapEmployeeToEmployeeResponseDTO(updatedEmployee);

        } catch (Exception e) {
            throw new RuntimeException("Failed to update employee: " + e.getMessage());
        }
    }
    public void deleteEmployee(String username) {

        Optional<Employee> employee = employeeRepository.findByUser_Username(username);
        if (employee.isPresent()) {
            employeeRepository.deleteById(employee.get().getId());
        } else {
            throw new EntityNotFoundException("Employee not found with username: " + username);
        }
    }
}
