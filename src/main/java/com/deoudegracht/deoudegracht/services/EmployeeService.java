package com.deoudegracht.deoudegracht.services;

import com.deoudegracht.deoudegracht.models.Employee;
import com.deoudegracht.deoudegracht.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public void getEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        if(employees.isEmpty()){
            throw new RuntimeException("No Employees found");
        }
        else
            System.out.println("Employees found");
    }
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }
        else
            throw new RuntimeException("Employee not found");
    }
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
        System.out.println("Employee saved");
    }
    public Boolean checkEmployeeExists(Employee employee) {
        return employeeRepository.findById(employee.getId()).isPresent();
    }
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
            System.out.println("Employee updated");
    }
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
            System.out.println("Employee deleted");
        }
}
