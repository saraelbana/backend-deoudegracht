package com.deoudegracht.deoudegracht.dtos;

public class MenuItemResponseDTO {
    private String name;
    private String description;
    private double price;
    private String category;
    private long id;

    public MenuItemResponseDTO() {
    }

    public MenuItemResponseDTO(String name, String description, double price, String category, long id) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
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

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
