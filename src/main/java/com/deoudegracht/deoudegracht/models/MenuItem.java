package com.deoudegracht.deoudegracht.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table(name = "menu-item")
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private double price;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private FoodCategoryType category;


    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    public MenuItem(String name, String description, double price, String category) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
    public MenuItem(String name, String description, double price, String category, Recipe recipe) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.recipe = recipe;
    }

    public MenuItem() {
    }
    public MenuItem(MenuItem menuItem, long id) {
        this.name = menuItem.getName();
        this.description = menuItem.getDescription();
        this.price = menuItem.getPrice();
        this.id = id;

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

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
