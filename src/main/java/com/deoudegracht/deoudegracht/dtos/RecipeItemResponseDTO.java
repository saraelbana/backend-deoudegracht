package com.deoudegracht.deoudegracht.dtos;

public class RecipeItemResponseDTO {
    private long id;
    private String name;
    private float quantity;
    private String unit;

    public RecipeItemResponseDTO() {
    }

    public RecipeItemResponseDTO(long id, String name, float quantity, String unit) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }

    public long getId() {
        return id;
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
