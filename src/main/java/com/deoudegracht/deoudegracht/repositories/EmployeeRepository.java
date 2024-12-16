package com.deoudegracht.deoudegracht.repositories;

import com.deoudegracht.deoudegracht.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByUser_Username(String username);

}
