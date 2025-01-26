package com.deoudegracht.deoudegracht.dtos;

import com.deoudegracht.deoudegracht.models.Recipe;

public class RecipeIngredientRequestDTO {
    private String name;
    private float quantity;
    private String unit;

    public RecipeIngredientRequestDTO() {
    }

    public RecipeIngredientRequestDTO(String name, float quantity, String unit) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "RecipeIngredientRequestDTO{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                '}';
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

}