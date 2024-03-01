package com.deoudegracht.deoudegracht.controllers;

import com.deoudegracht.deoudegracht.dtos.EmployeeRequestDTO;
import com.deoudegracht.deoudegracht.dtos.EmployeeResponseDTO;
import com.deoudegracht.deoudegracht.mappers.EmployeeMapper;
import com.deoudegracht.deoudegracht.services.EmployeeService;
import com.sun.source.util.SourcePositions;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.SocketTimeoutException;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    private EmployeeMapper employeeMapper;
    public EmployeeController(EmployeeService employeeService, EmployeeMapper employeeMapper) {
        this.employeeService = employeeService;
        this.employeeMapper = new EmployeeMapper();
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
        employeeService.createEmployee(employeeMapper.mapEmployeeRequestDTOToEmployee(employeeRequestDTO));
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{id}")
    ResponseEntity<EmployeeResponseDTO> updateEmployee(@RequestParam Long id, @RequestBody EmployeeRequestDTO employeeRequestDTO) {
        employeeService.updateEmployee(employeeMapper.mapEmployeeRequestDTOToEmployee(employeeRequestDTO, id));
        return ResponseEntity.ok(new EmployeeResponseDTO());
    }
    @DeleteMapping("/{id}")
    ResponseEntity<EmployeeResponseDTO> deleteEmployee(@RequestParam Long id) {
        return ResponseEntity.ok(new EmployeeResponseDTO());
    }
}
