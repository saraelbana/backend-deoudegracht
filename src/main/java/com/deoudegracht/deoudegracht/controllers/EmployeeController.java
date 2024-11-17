package com.deoudegracht.deoudegracht.controllers;

import com.deoudegracht.deoudegracht.dtos.EmployeeRequestDTO;
import com.deoudegracht.deoudegracht.dtos.EmployeeResponseDTO;
import com.deoudegracht.deoudegracht.mappers.EmployeeMapper;
import com.deoudegracht.deoudegracht.services.EmployeeService;

import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    ResponseEntity<?>/*<List<EmployeeResponseDTO>>*/ getAllEmployees() {
        try {
            return ResponseEntity.ok().body(employeeService.getAllEmployees());

        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> getEmployeeById(@PathVariable("id") Long id) {
        try {
            EmployeeResponseDTO employeeResponseDTO = employeeService.getEmployeeById(id);
            return ResponseEntity.ok().body(employeeResponseDTO);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user")
    ResponseEntity<EmployeeResponseDTO> getEmployeeByUsername(@RequestParam String username) {
        try{
            return ResponseEntity.ok().body(employeeService.getEmployeeByUsername(username));
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    ResponseEntity<?>createEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO) {
        try {
            EmployeeResponseDTO newCreatedEmployeeDto = employeeService.createEmployee(EmployeeMapper.mapEmployeeRequestDTOToEmployee(employeeRequestDTO));
            System.out.println("Hello there new Employee is created with ID number" + newCreatedEmployeeDto.getId());

            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + newCreatedEmployeeDto.getId()).toUriString());
            System.out.println("Employee is created");
            return ResponseEntity.created(uri).body(newCreatedEmployeeDto);
        }
        catch (Exception e) {
            System.out.println("error happened " + e.getMessage());
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }
    @PutMapping()
    ResponseEntity<?> updateEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO) {
        try{
            return ResponseEntity.ok(
                            employeeService.updateEmployee(
                                    EmployeeMapper.mapEmployeeRequestDTOToEmployee(
                                            employeeRequestDTO)
                            ));
        }catch (Exception e){
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteEmployee(@PathVariable long  id) {
        try {
            employeeService.deleteEmployee(id);
            return ResponseEntity.ok().body("Employee deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }
}
