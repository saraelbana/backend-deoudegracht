package com.deoudegracht.deoudegracht.dtos;

import com.deoudegracht.deoudegracht.models.Recipe;

public class RecipeItemRequestDTO {
    private String name;
    private float quantity;
    private String unit;
    private Recipe recipe;

    public RecipeItemRequestDTO() {
    }

    public RecipeItemRequestDTO(String name, float quantity, String unit) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public float getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    public Recipe getRecipe() {
        return recipe;
    }
}
