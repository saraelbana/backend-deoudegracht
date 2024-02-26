package com.deoudegracht.deoudegracht.controllers;

import com.deoudegracht.deoudegracht.dtos.EmployeeRequestDTO;
import com.deoudegracht.deoudegracht.dtos.EmployeeResponseDTO;
import com.sun.source.util.SourcePositions;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.SocketTimeoutException;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    public EmployeeController() {
    }
    @GetMapping
    ResponseEntity<EmployeeResponseDTO> getEmployees() {
        EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
        //
        return ResponseEntity.ok(employeeResponseDTO);
    }
    @GetMapping("/{id}")
    ResponseEntity<EmployeeResponseDTO> getEmployeeById(@RequestParam Long id) {
        EmployeeResponseDTO employeeResponseDTO = new EmployeeResponseDTO();
        return ResponseEntity.ok(employeeResponseDTO);
    }
    @PostMapping()
    ResponseEntity<Void>createEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO) {
        System.out.println("Sara " + employeeRequestDTO);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{id}")
    ResponseEntity<EmployeeResponseDTO> updateEmployee(@RequestParam Long id, @RequestBody EmployeeRequestDTO employeeRequestDTO) {
        return ResponseEntity.ok(new EmployeeResponseDTO());
    }
    @DeleteMapping("/{id}")
    ResponseEntity<EmployeeResponseDTO> deleteEmployee(@RequestParam Long id) {
        return ResponseEntity.ok(new EmployeeResponseDTO());
    }
}
