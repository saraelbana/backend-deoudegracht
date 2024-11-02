package com.deoudegracht.deoudegracht.dtos;

import com.deoudegracht.deoudegracht.models.Recipe;

public class MenuItemResponseDTO {
    private String name;
    private String description;
    private double price;
    private String category;
    private long id;
    private Recipe recipe;

    public MenuItemResponseDTO(long id, String name, String description, double price, Recipe recipe) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.id = id;
        this.recipe = recipe;
    }

    public MenuItemResponseDTO() {
    }


    public long getId() {
        return id;
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

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

}
