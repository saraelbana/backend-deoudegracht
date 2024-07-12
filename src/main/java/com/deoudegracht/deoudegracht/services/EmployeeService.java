package com.deoudegracht.deoudegracht.services;

import com.deoudegracht.deoudegracht.dtos.EmployeeResponseDTO;
import com.deoudegracht.deoudegracht.mappers.EmployeeMapper;
import com.deoudegracht.deoudegracht.models.Employee;
import com.deoudegracht.deoudegracht.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public List<EmployeeResponseDTO> getAllEmployees() {
        try {
            List <EmployeeResponseDTO> employeesResponseDtoList = new ArrayList<>();
            List <Employee> employeesList = employeeRepository.findAll();
            for(Employee employee : employeesList) {
                employeesResponseDtoList.add(EmployeeMapper.mapEmployeeToEmployeeResponseDTO(employee));

            }
            return employeesResponseDtoList;
        }catch (Exception e) {
            throw new RuntimeException("No Employees found");
        }
    }
    public Employee getEmployeeById(long id) {
        try {
            Optional<Employee> employee = employeeRepository.findById(id);
            return employee.get();
        }catch (Exception e) {
            throw new RuntimeException("Employee not found");
        }
    }
    public EmployeeResponseDTO createEmployee(Employee employee) {
        try {
            employeeRepository.save(employee);

            System.out.println(employee.getId());
            return EmployeeMapper.mapEmployeeToEmployeeResponseDTO(employee);
        }catch (Exception e) {
            throw new RuntimeException("Creating employee process failed");
        }
    }
    public Boolean checkEmployeeExists(Employee employee) {
        try {
            return employeeRepository.findById(employee.getId()).isPresent();
        }catch (Exception e) {
            throw new RuntimeException("Searching for employee process failed");
        }
    }
    public Employee updateEmployee(Employee employee) {
        try {
            employeeRepository.save(employee);
            System.out.println("Employee updated");
            return employee;
        }catch (Exception e) {
            throw new RuntimeException("Updating employee process failed");
        }
    }
    public void deleteEmployee(Long id) {
        employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        try {
            employeeRepository.deleteById(id);
            System.out.println("Employee deleted");
        }catch (Exception e) {
            throw new RuntimeException("Deleting employee process failed");
        }
    }
}
