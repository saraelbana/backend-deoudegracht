package com.deoudegracht.deoudegracht.servicesTests;

import com.deoudegracht.deoudegracht.DeOudegrachtApplication;
import com.deoudegracht.deoudegracht.dtos.EmployeeResponseDTO;
import com.deoudegracht.deoudegracht.models.Employee;
import com.deoudegracht.deoudegracht.models.Role;
import com.deoudegracht.deoudegracht.models.User;
import com.deoudegracht.deoudegracht.repositories.EmployeeRepository;
import com.deoudegracht.deoudegracht.services.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@ContextConfiguration(classes={DeOudegrachtApplication.class})
public class EmployeeServiceTest {
    @Autowired EmployeeService employeeService;
    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    Employee employee;

    @Test
    public void testCreateEmployee() {
        //given
        String username = "testCreateUsername";
        Employee employee = new Employee();
        employee.setUser(new User(username, "testingPassword", "firstname", "lastname", "test@test.com", "phone"));
        employee.setRole(Role.EMPLOYEE);

        // when
        Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
        EmployeeResponseDTO createdEmployee = employeeService.createEmployee(employee);

        //then
        assertEquals(employee.getUser().getUsername(), createdEmployee.getUsername());
        assertEquals(employee.getUser().getFirstname(), createdEmployee.getFirstname());
        assertEquals(employee.getUser().getLastname(), createdEmployee.getLastname());
        assertEquals(employee.getUser().getEmail(), createdEmployee.getEmail());
        assertEquals(employee.getUser().getPhone(), createdEmployee.getPhone());
        assertEquals(employee.getRole().toString(), createdEmployee.getRole());
        employeeService.deleteEmployee(username);

    }
    @Test
    public void testGetEmployeeByUsername(){
        //given
        String username = "testGetUsername";
        String expectedUsername = "testGetUsername";
        Employee employee = new Employee();
        employee.setUser(new User(username, "testingPassword", "firstname", "lastname", "test@test.com", "phone"));
        employee.setRole(Role.EMPLOYEE);
        EmployeeResponseDTO mockSavedEmployeeResponseDTO = employeeService.createEmployee(employee);

        //when
        Mockito.when(employeeRepository.findByUser_Username(username)).thenReturn(Optional.of(employee));
        EmployeeResponseDTO found = employeeService.getEmployeeByUsername(username);

        //then
        assertEquals(expectedUsername, found.getUsername());
        employeeService.deleteEmployee(username);
    }
   @Test
    public void testUpdateEmployee() {
       //given
       String uniqueUsername = "testUpdateUsername";
       Employee oldEmployeeData = new Employee();
       oldEmployeeData.setUser(new User(uniqueUsername, "testingPasswordOld", "firstnameOld", "lastnameOld", "oldTest@oldtest.com", "phone.old"));
       oldEmployeeData.setRole(Role.EMPLOYEE);
       EmployeeResponseDTO createdEmployee = employeeService.createEmployee(oldEmployeeData);

       Employee newEmployeeData = new Employee();
       newEmployeeData.setUser(new User(uniqueUsername, "testingPasswordNew", "firstnameNew", "lastnameNew", "newTest@newTest.com", "phone.new"));
       newEmployeeData.setRole(Role.CHEF);

       //when
       Mockito.when(employeeRepository.findByUser_Username(uniqueUsername)).thenReturn(Optional.of(oldEmployeeData));
       Mockito.when(employeeRepository.save(any(Employee.class))).thenReturn(newEmployeeData);
       EmployeeResponseDTO updatedEmployee = employeeService.updateEmployee(newEmployeeData);

       //then
       assertEquals(updatedEmployee.getId(), createdEmployee.getId());
       employeeService.deleteEmployee(uniqueUsername);
   }

//   @Test
//    public void testDeleteEmployee() {
//       //given
//       String username = "test.delete.username";
//       Employee employee = new Employee();
//       employee.setUser(new User(username, "testingPassword", "firstname", "lastname", "test@test.com", "phone"));
//       employee.setRole(Role.EMPLOYEE);
//       employee.setId(1L);
////       EmployeeResponseDTO createdEmployee = employeeService.createEmployee(employee);
////       employee.setId(createdEmployee.getId());
//
//       //when
//       Mockito.when(employeeRepository.findByUser_Username(username)).thenReturn(Optional.of(employee));
//       employeeService.deleteEmployee(username);
//
//       //then
//       //verify the delete user method by searching for the employee by username should return empty
//      //
//       verify(employeeRepository).findByUser_Username(username);
//       verify(employeeRepository).deleteById(employee.getId());
//
//    }

}
