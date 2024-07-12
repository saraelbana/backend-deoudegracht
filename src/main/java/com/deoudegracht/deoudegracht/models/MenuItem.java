package com.deoudegracht.deoudegracht.models;

import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table(name = "menu-item")
public class MenuItem {
    private String name;
    private String description;
    private double price;
    private String category;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public MenuItem(String name, String description, double price, String category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public MenuItem() {
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}
