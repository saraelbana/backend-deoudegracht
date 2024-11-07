package com.deoudegracht.deoudegracht.mappers;

import com.deoudegracht.deoudegracht.dtos.EmployeeRequestDTO;
import com.deoudegracht.deoudegracht.dtos.EmployeeResponseDTO;
import com.deoudegracht.deoudegracht.models.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    static public EmployeeResponseDTO mapEmployeeToEmployeeResponseDTO(Employee employee) {
        return new EmployeeResponseDTO(
                employee.getId(),
                employee.getFirstname(),
                employee.getLastname(),
                employee.getEmail(),
                employee.getPhone(),
                employee.getUser().getUsername(),
                employee.getUser().getRole());
    }
    static public Employee mapEmployeeRequestDTOToEmployee(EmployeeRequestDTO employeeRequestDTO){
        return new Employee(
                employeeRequestDTO.getFirstname(),
                employeeRequestDTO.getLastname(),
                employeeRequestDTO.getEmail(),
                employeeRequestDTO.getPhone(),
                employeeRequestDTO.getUsername(),
                employeeRequestDTO.getPassword(),
                employeeRequestDTO.getRole());
    }
    static public Employee mapEmployeeRequestDTOToEmployee(EmployeeRequestDTO employeeRequestDTO, long id){
        return new Employee(mapEmployeeRequestDTOToEmployee(employeeRequestDTO), id);
    }

}
