package com.deoudegracht.deoudegracht.dtos;

import com.deoudegracht.deoudegracht.models.FoodCategoryType;
import org.springframework.web.multipart.MultipartFile;

public class MenuItemRequestDTO {
    private String name;
    private String description;
    private double price;
    private FoodCategoryType category;
    private long recipeId;
    private MultipartFile image = null;

    public MenuItemRequestDTO() {
    }
    public MenuItemRequestDTO(String name, String description, double price, FoodCategoryType category, int recipeId, MultipartFile image) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.recipeId = recipeId;
        this.image = image;
    }
    public long getRecipeId() {
        return recipeId;
    }
    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
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

    public FoodCategoryType getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(FoodCategoryType category) {
        this.category = category;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

}
