package com.deoudegracht.deoudegracht.controllers;

import com.deoudegracht.deoudegracht.dtos.EmployeeRequestDTO;
import com.deoudegracht.deoudegracht.dtos.EmployeeResponseDTO;
import com.deoudegracht.deoudegracht.mappers.EmployeeMapper;
import com.deoudegracht.deoudegracht.services.EmployeeService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping()
    ResponseEntity<?>createEmployee(@Valid @RequestBody EmployeeRequestDTO employeeRequestDTO) {
        try {
            employeeRequestDTO.setUsername(employeeRequestDTO.getUsername().toLowerCase());
            EmployeeResponseDTO newCreatedEmployeeDto = employeeService.createEmployee(EmployeeMapper.mapEmployeeRequestDTOToEmployee(employeeRequestDTO));


            URI uri = URI.create(ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/" + newCreatedEmployeeDto.getUsername())
                    .toUriString());


            return ResponseEntity.created(uri).body(newCreatedEmployeeDto);
        }
        catch (Exception e) {

            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }
    @GetMapping
    ResponseEntity<?>/*<List<EmployeeResponseDTO>>*/ getAllEmployees() {
        try {
            return ResponseEntity.ok().body(employeeService.getAllEmployees());

        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }

    @GetMapping("/{username}")
    ResponseEntity<EmployeeResponseDTO> getEmployeeByUsername(@PathVariable String username /*@RequestParam String username*/) {
        username = username.toLowerCase();
        try{
            return ResponseEntity.ok().body(employeeService.getEmployeeByUsername(username.toLowerCase()));
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{username}")
    ResponseEntity<?> updateEmployee(@PathVariable String username, @RequestBody EmployeeRequestDTO employeeRequestDTO) {
        try {
            return ResponseEntity.ok().body(
                    employeeService.updateEmployee(
                            EmployeeMapper.mapEmployeeRequestDTOToEmployee(
                                    employeeRequestDTO)
                    ));
        } catch (Exception e) {

            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }
    @DeleteMapping
    ResponseEntity<?> deleteEmployee(@RequestParam String username) {
        try {
            employeeService.deleteEmployee(username.toLowerCase());
            return ResponseEntity.ok().body("Employee deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }
}
