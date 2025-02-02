package com.deoudegracht.deoudegracht.models;

import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_username", referencedColumnName = "username", nullable = false)
    User user;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
    public Employee() {
    }

    public Employee(String firstname, String lastname, String email, String username, String password, String role, String phone) {
        this.user = new User(username, password, firstname, lastname, email, phone, Role.valueOf(role));
        this.role = Role.valueOf(role);
        System.out.println("Hello there from the employee constructor password is" + this.user.getPassword());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}