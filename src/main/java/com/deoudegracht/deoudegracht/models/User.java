package com.deoudegracht.deoudegracht.models;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(unique = true)
    @NotNull(message = "Username is required")
    private String username;
    @NotNull(message = "password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @NotNull(message = "Roles are required")
    private Set<Role> roles = new HashSet<>();
    @OneToOne(mappedBy = "user")
    private Employee employee;

    public User(String username, String password, String role) {
        System.out.println("HELLO FROM USER");
        this.username = username;
        this.password = password;
        this.roles.add(new Role(RoleType.valueOf(role)));

    }

    public User() {
    }
    public User(String username, String role) {
        this.username = username;
        this.roles.add(new Role(RoleType.valueOf(role)));
    }
    public User(String username) {
        this.username = username;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public Employee getEmployee() {
        return employee;
    }
    public long getEmployeeId() {
        return employee.getId();
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getRole() {
        //return first role in the set
        return roles.iterator().next().getRoleType().toString();
    }
}
