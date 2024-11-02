package com.deoudegracht.deoudegracht.dtos;

import com.deoudegracht.deoudegracht.models.MenuItem;
import jakarta.annotation.Nullable;

import java.util.List;

public class RecipeRequestDTO {
    private String recipeName;
    private String description;

    private List<RecipeItemRequestDTO> recipeItemsRequestDTO;

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public void setRecipeItems(List<RecipeItemRequestDTO> recipeItems) {
        this.recipeItemsRequestDTO = recipeItems;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public List<RecipeItemRequestDTO> getRecipeItems() {
        return recipeItemsRequestDTO;
    }
}
