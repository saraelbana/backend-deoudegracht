package com.deoudegracht.deoudegracht.dtos;

import com.deoudegracht.deoudegracht.models.FoodCategoryType;

public class MenuItemResponseDTO {
    private String name;
    private String description;
    private double price;
    private String category;
    private long id;
    private long recipeId;
    private String imagePath;

    public MenuItemResponseDTO(long id, String name, String description, double price, FoodCategoryType category, long recipeId, String imagePath) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category.toString();
        this.id = id;
        this.recipeId = recipeId;
        this.imagePath = imagePath;
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

    public long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(long recipeId) {
        this.recipeId = recipeId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }


}
