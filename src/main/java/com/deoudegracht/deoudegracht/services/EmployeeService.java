package com.deoudegracht.deoudegracht.services;

import com.deoudegracht.deoudegracht.models.Employee;
import com.deoudegracht.deoudegracht.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public void getEmployees() {
    }
    public void getEmployeeById(Long id) {
    }
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
    public void updateEmployee(Long id) {
    }
    public void deleteEmployee(Long id) {
    }
}
