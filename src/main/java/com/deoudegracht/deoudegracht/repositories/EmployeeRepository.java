package com.deoudegracht.deoudegracht.repositories;

import com.deoudegracht.deoudegracht.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
