package com.deoudegracht.deoudegracht.mappers;

import com.deoudegracht.deoudegracht.dtos.EmployeeRequestDTO;
import com.deoudegracht.deoudegracht.dtos.EmployeeResponseDTO;
import com.deoudegracht.deoudegracht.models.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public EmployeeResponseDTO mapEmployeeToEmployeeResponseDTO(Employee employee) {
        return null;
    }
    public Employee mapEmployeeRequestDTOToEmployee(EmployeeRequestDTO employeeRequestDTO){
        return new Employee(employeeRequestDTO.getFirstName(), employeeRequestDTO.getLastName(), employeeRequestDTO.getEmail(), employeeRequestDTO.getUsername(), employeeRequestDTO.getPassword());
    }
    public Employee mapEmployeeRequestDTOToEmployee(EmployeeRequestDTO employeeRequestDTO, Long id){
        return new Employee(mapEmployeeRequestDTOToEmployee(employeeRequestDTO), id);
    }

}
