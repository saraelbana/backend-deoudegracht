package com.deoudegracht.deoudegracht.mappers;

import com.deoudegracht.deoudegracht.dtos.EmployeeRequestDTO;
import com.deoudegracht.deoudegracht.dtos.EmployeeResponseDTO;
import com.deoudegracht.deoudegracht.models.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    static public EmployeeResponseDTO mapEmployeeToEmployeeResponseDTO(Employee employee) {
        return new EmployeeResponseDTO(employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getUsername(), employee.getPassword(), employee.getId());
    }
    static public Employee mapEmployeeRequestDTOToEmployee(EmployeeRequestDTO employeeRequestDTO){
        return new Employee(employeeRequestDTO.getFirstName(), employeeRequestDTO.getLastName(), employeeRequestDTO.getEmail(), employeeRequestDTO.getUsername(), employeeRequestDTO.getPassword());
    }
    static public Employee mapEmployeeRequestDTOToEmployee(EmployeeRequestDTO employeeRequestDTO, Long id){
        return new Employee(mapEmployeeRequestDTOToEmployee(employeeRequestDTO), id);
    }

}
