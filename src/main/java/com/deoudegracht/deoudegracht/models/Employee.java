package com.deoudegracht.deoudegracht.models;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import org.jetbrains.annotations.NotNull;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "firstname")
    @NotNull
    private String firstname;
    @Column(name = "lastname")
    @NotNull
    private String lastname;

    @Email(message = "Please enter a valid email")
    private String email;
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_username", referencedColumnName = "username")
    User user;

    public Employee() {
    }

    public Employee(@NotNull String firstname, @NotNull String lastname, String email, String phone, @NotNull String username, @NotNull String password, String role) {
        System.out.println("HELLO FROM EMPLOYEE");
        this.firstname = firstname;
        System.out.println(
                this.firstname + " ");
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        System.out.println(
                this.phone + " ROLETYPE " + role);
        this.user = new User(username, password, role);

        System.out.println(
                this.firstname + " "
                + this.lastname + " "
                + this.email + " "
                + this.phone + " "
                + this.user.getUsername() + " "
                + this.user.getPassword() + " "
                + this.user.getRoles().toString());
    }

    public Employee(Employee employee, long id) {
        this.firstname = employee.getFirstname();
        this.lastname = employee.getLastname();
        this.email = employee.getEmail();
        this.user = employee.getUser();
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}