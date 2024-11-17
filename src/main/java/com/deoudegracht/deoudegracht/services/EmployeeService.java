package com.deoudegracht.deoudegracht.services;

import com.deoudegracht.deoudegracht.dtos.EmployeeResponseDTO;
import com.deoudegracht.deoudegracht.mappers.EmployeeMapper;
import com.deoudegracht.deoudegracht.models.Employee;
import com.deoudegracht.deoudegracht.models.Role;
import com.deoudegracht.deoudegracht.models.User;
import com.deoudegracht.deoudegracht.repositories.EmployeeRepository;
import com.deoudegracht.deoudegracht.repositories.RoleRepository;
import com.deoudegracht.deoudegracht.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final RoleRepository roleRepository;
    private final UserService userService;

    public EmployeeService(EmployeeRepository employeeRepository, UserService userService, RoleRepository roleRepository) {
        this.employeeRepository = employeeRepository;
        this.userService = userService;
        this.roleRepository = roleRepository;
    }
    public List<EmployeeResponseDTO> getAllEmployees() {
        try {
            List <EmployeeResponseDTO> employeesResponseDtoList;
            List <Employee> employeesList = employeeRepository.findAll();
            if(employeesList.isEmpty()) {
                throw new RuntimeException("No Employees found");
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
    public EmployeeResponseDTO getEmployeeById(long id) {
        try {
            Optional<Employee> employee = employeeRepository.findById(id);
            return EmployeeMapper.mapEmployeeToEmployeeResponseDTO(employee.get());
        }catch (Exception e) {
            throw new RuntimeException("Employee not found");
        }
    }

    public EmployeeResponseDTO getEmployeeByUsername(String username) {
        try {
            Optional<User> user = userService.findByUsername(username);
            System.out.println(user.get().getEmployee().getFirstname() + " " + user.get().getEmployee().getLastname());
            if(user.isPresent()) {
                return EmployeeMapper.mapEmployeeToEmployeeResponseDTO(user.get().getEmployee());
            }
            throw new RuntimeException("Employee not found");
        }
        catch (Exception e) {
            throw new RuntimeException("Employee not found");
        }

    }
    public EmployeeResponseDTO createEmployee(Employee employee) {
        if(userService.findByUsername(employee.getUser().getUsername()).isEmpty()){
            try {

                for(Role role : employee.getUser().getRoles()) {
                    roleRepository.save(role);
                }
                employeeRepository.save(employee);
                System.out.println(employee.getId());
                return EmployeeMapper.mapEmployeeToEmployeeResponseDTO(employee);
            }catch (Exception e) {
                throw new RuntimeException("creating employee process failed" + e.getMessage());
            }
        }
        else {
            throw new RuntimeException("username already exists");
        }

    }
    public Boolean checkEmployeeExists(Employee employee) {
        //how I'm checking if employee exists using the getID() if I dont know if this employee is present or not then i for sure don't know his ID
        // the logic here needs to be adjusted
        try {
            return employeeRepository.findById(employee.getId()).isPresent();
        }catch (Exception e) {
            throw new RuntimeException("Searching for employee process failed");
        }
    }
    private Employee getUsernameData(String username){
        try {
            Optional<User> user = userService.findByUsername(username);
            System.out.println(user.get().getEmployee().getFirstname() + " " + user.get().getEmployee().getLastname());
            if(user.isPresent()) {
                return user.get().getEmployee();
            }
            throw new RuntimeException("Employee not found");
        }
        catch (Exception e) {
            throw new RuntimeException("Employee not found");
        }
    }

    public EmployeeResponseDTO updateEmployee(Employee employee) {
        try {
            Employee employeeToUpdate =
                    getUsernameData(employee
                            .getUser()
                            .getUsername());
            employee.setId(employeeToUpdate.getId());
            employee.setUser(employeeToUpdate.getUser());
            employeeRepository.save(employee);
            System.out.println("Employee updated");
            return EmployeeMapper.mapEmployeeToEmployeeResponseDTO(employee);
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public void deleteEmployee(long id) {
        employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        try {
            employeeRepository.deleteById(id);
            System.out.println("Employee deleted");
        }catch (Exception e) {
            throw new RuntimeException("Deleting employee process failed");
        }
    }
}
