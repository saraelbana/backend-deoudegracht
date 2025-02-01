package com.deoudegracht.deoudegracht.services;

import com.deoudegracht.deoudegracht.dtos.EmployeeResponseDTO;
import com.deoudegracht.deoudegracht.mappers.EmployeeMapper;
import com.deoudegracht.deoudegracht.models.Employee;
import com.deoudegracht.deoudegracht.repositories.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.*;

//2 successfull integration testing
// 2 classes from service layer with
// 100% coverage
//minimal 10 unit tests
@Service
@Transactional // Transactional is used to rollback the transaction in case of exception
//If any operation within the transaction fails, all changes are rolled back (like they never happened)
//If all operations succeed, all changes are committed to the database
// if an error occurs mid-operation, you might end up with inconsistent data in your database. With it,
// Spring ensures database consistency by automatically managing the transaction boundaries.
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final UserService userService;

    public EmployeeService(EmployeeRepository employeeRepository, UserService userService) {
        this.employeeRepository = employeeRepository;
        this.userService = userService;
    }

    public EmployeeResponseDTO createEmployee(Employee employee) {
        String username = employee.getUser().getUsername();
        if (userService.findByUsername(username).isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        try {
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
                //throw new RuntimeException("No Employees found");
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

            System.out.println(employee.get().getUser().getFirstname() + " " + employee.get().getUser().getLastname());
            return EmployeeMapper.mapEmployeeToEmployeeResponseDTO(employee.get());
        } catch (Exception e) {
            throw new RuntimeException("Employee not found");
        }
    }

//old code
    public EmployeeResponseDTO updateEmployee(Employee newDataEmployee) {
        try {
            Optional<Employee> existingEmployeeOptional = employeeRepository.findByUser_Username(newDataEmployee.getUser().getUsername());

            if (!existingEmployeeOptional.isPresent()) {
                throw new RuntimeException("Employee not found");
            }

            System.out.println(existingEmployeeOptional.get().getUser().getFirstname() + " " + existingEmployeeOptional.get().getUser().getLastname());
            Employee existingEmployee = existingEmployeeOptional.get();
            existingEmployee.getUser().setFirstname(newDataEmployee.getUser().getFirstname());
            existingEmployee.getUser().setLastname(newDataEmployee.getUser().getLastname());
            existingEmployee.getUser().setEmail(newDataEmployee.getUser().getEmail());
            existingEmployee.getUser().setPhone(newDataEmployee.getUser().getPhone());
            existingEmployee.setRole(newDataEmployee.getRole());
            System.out.println(existingEmployee.getUser().getFirstname() + " " + existingEmployee.getUser().getLastname());


            Employee updatedEmployee = employeeRepository.save(existingEmployee);
            System.out.println("Employee updated successfully");
            return EmployeeMapper.mapEmployeeToEmployeeResponseDTO(updatedEmployee);

        } catch (Exception e) {
            throw new RuntimeException("Failed to update employee: " + e.getMessage());
        }
    }
    public void deleteEmployee(String username) {

        Optional<Employee> employee = employeeRepository.findByUser_Username(username);
//        if (employee.isEmpty()) {
//            throw new RuntimeException("Employee not found");
//        } else {
//            try {
//                employeeRepository.deleteById(employee.get().getId());
//                System.out.println("Employee deleted");
//            } catch (Exception e) {
//                throw new RuntimeException("Deleting employee process failed");
//            }
//        }
        if (employee.isPresent()) {
            employeeRepository.deleteById(employee.get().getId());
        } else {
            throw new EntityNotFoundException("Employee not found with username: " + username);
        }
    }
}
