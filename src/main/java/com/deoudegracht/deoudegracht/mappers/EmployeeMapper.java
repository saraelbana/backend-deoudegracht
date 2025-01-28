package com.deoudegracht.deoudegracht.mappers;


import com.deoudegracht.deoudegracht.dtos.EmployeeRequestDTO;
import com.deoudegracht.deoudegracht.dtos.EmployeeResponseDTO;
import com.deoudegracht.deoudegracht.models.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    static public Employee mapEmployeeRequestDTOToEmployee(EmployeeRequestDTO employeeRequestDTO){
        return new Employee(employeeRequestDTO.getFirstname(), employeeRequestDTO.getLastname(), employeeRequestDTO.getEmail(), employeeRequestDTO.getUsername(), employeeRequestDTO.getPassword(), employeeRequestDTO.getRole(), employeeRequestDTO.getPhone());

    }
    static public EmployeeResponseDTO mapEmployeeToEmployeeResponseDTO(Employee employee) {
        return new EmployeeResponseDTO(
                employee.getId(),
                employee.getUser().getFirstname(),
                employee.getUser().getLastname(),
                employee.getUser().getEmail(),
                employee.getUser().getUsername(),
                employee.getRole().toString(),
                employee.getUser().getPhone()
        );
    }


//    static public Employee mapEmployeeRequestDTOToEmployee(EmployeeRequestDTO employeeRequestDTO, long id) {
//        Employee employee = mapEmployeeRequestDTOToEmployee(employeeRequestDTO);
//        employee.setId(id);
//        return employee;
//    }

}
