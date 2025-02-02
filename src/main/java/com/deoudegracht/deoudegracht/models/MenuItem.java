package com.deoudegracht.deoudegracht.models;

import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table(name = "menu_item")
public class MenuItem {

    public MenuItem(String name, String description, double price, FoodCategoryType category, long recipeId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.recipeId = recipeId;
    }

    public MenuItem() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private double price;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FoodCategoryType category;
    @Column(name = "recipe_id", nullable = false)
    private long recipeId;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getPrice() {
        return price;
    }
    public FoodCategoryType getCategory() {
        return category;
    }
    public void setCategory(FoodCategoryType category) {
        this.category = category;
    }
    public long getRecipeId() {
        return recipeId;
    }
    public void setRecipeId(long recipeId) {
        this.recipeId = recipeId;
    }
    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

}
