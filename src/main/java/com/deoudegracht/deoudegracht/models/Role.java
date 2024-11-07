package com.deoudegracht.deoudegracht.models;

import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class  Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleType roleType;

    // Constructors, getters, and setters

    public Role() {}

    public Role(RoleType roleType) {
        this.roleType = roleType;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleType.toString();
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }
}