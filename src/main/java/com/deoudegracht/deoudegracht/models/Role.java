package com.deoudegracht.deoudegracht.models;


public enum Role {
    EMPLOYEE,
    ADMIN,
    CHEF,
    WAITER;
    public String getRoleName() {
        return this.name();
    }
}