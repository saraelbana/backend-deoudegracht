package com.deoudegracht.deoudegracht.dtos;

import java.util.ArrayList;
import java.util.List;

public class RecipeResponseDTO {
    private long id;
    private String recipeName;
    private String description;
    private String category;
    private MenuItemResponseDTO menuItem;
    private List<RecipeItemResponseDTO> recipeItems = new ArrayList<>();

    public List<String> getInstructionSteps() {
        return instructionSteps;
    }

    public void setInstructionSteps(List<String> instructionSteps) {
        this.instructionSteps = instructionSteps;
    }

    private List<String> instructionSteps = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getDescription() {
        return description;
    }

    public List<RecipeItemResponseDTO> getRecipeItems() {
        return recipeItems;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRecipeItems(List<RecipeItemResponseDTO> recipeItems) {
        this.recipeItems = recipeItems;
    }

    public void setMenuItem(MenuItemResponseDTO menuItem) {
        this.menuItem = menuItem;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
