package com.deoudegracht.deoudegracht.controllers;

import com.deoudegracht.deoudegracht.dtos.EmployeeRequestDTO;
import com.deoudegracht.deoudegracht.dtos.EmployeeResponseDTO;
import com.deoudegracht.deoudegracht.mappers.EmployeeMapper;
import com.deoudegracht.deoudegracht.models.Employee;
import com.deoudegracht.deoudegracht.services.EmployeeService;
import com.sun.source.util.SourcePositions;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.SocketTimeoutException;
import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    ResponseEntity <List<EmployeeResponseDTO>> getEmployees() {
        try {

            return ResponseEntity.ok().body(employeeService.getAllEmployees());

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{id}")
    ResponseEntity<EmployeeResponseDTO> getEmployeeById(@PathVariable long id) {

        try{
            return ResponseEntity.ok().body(EmployeeMapper.mapEmployeeToEmployeeResponseDTO(employeeService.getEmployeeById(id)));
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    ResponseEntity<?>createEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO) {
        try{
            Employee newToCreateEmployee;
            try {
                newToCreateEmployee = EmployeeMapper.mapEmployeeRequestDTOToEmployee(employeeRequestDTO);
            } catch (Exception e) {
                return ResponseEntity.unprocessableEntity().body("Entered Employee Data is not correct");
            }
            EmployeeResponseDTO newCreatedEmployeeDto = employeeService.createEmployee(newToCreateEmployee);
            System.out.println("Hello there here we are Employee with ID number" + newCreatedEmployeeDto.getId());

            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + newCreatedEmployeeDto.getId()).toUriString());

            return ResponseEntity.created(uri).body(newCreatedEmployeeDto);
        }
        catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body("Creation failed");
        }
    }
    @PutMapping("/{id}")
    ResponseEntity<EmployeeResponseDTO> updateEmployee(@PathVariable Long id, @RequestBody EmployeeRequestDTO employeeRequestDTO) {

        try{

            return ResponseEntity.ok(EmployeeMapper.mapEmployeeToEmployeeResponseDTO(employeeService.updateEmployee(EmployeeMapper.mapEmployeeRequestDTOToEmployee(employeeRequestDTO, id))));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        try {
            employeeService.deleteEmployee(id);
            return ResponseEntity.ok().body("Employee deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
