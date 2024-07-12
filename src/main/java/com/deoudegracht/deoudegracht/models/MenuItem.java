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
    Recipe recipe = new Recipe();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public MenuItem(String name, String description, double price, String category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }
    public MenuItem(String name, String description, double price, String category, Recipe recipe) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.recipe = recipe;
    }

    public MenuItem() {
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

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Recipe getRecipe() {
        return recipe;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
