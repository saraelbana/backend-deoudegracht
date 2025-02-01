package com.deoudegracht.deoudegracht.models;


public enum Role {
    EMPLOYEE,
    ADMIN,
    CHEF,
    WAITER,
    GUEST;
    public String getRoleName() {
        return this.name();
    }
}