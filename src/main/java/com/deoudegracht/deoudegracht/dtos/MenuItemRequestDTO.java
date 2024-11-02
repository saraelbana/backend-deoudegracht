package com.deoudegracht.deoudegracht.dtos;

import com.deoudegracht.deoudegracht.models.Recipe;

public class MenuItemRequestDTO {
    private String name;
    private String description;
    private double price;
    private String category;


    public MenuItemRequestDTO() {
    }

    public MenuItemRequestDTO(String name, String description, double price, String category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
