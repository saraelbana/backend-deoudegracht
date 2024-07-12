package com.deoudegracht.deoudegracht.models;

import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu {
    private String name;
    private String description;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Menu() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
