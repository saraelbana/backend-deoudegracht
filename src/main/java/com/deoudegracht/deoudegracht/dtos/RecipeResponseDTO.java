package com.deoudegracht.deoudegracht.dtos;

import com.deoudegracht.deoudegracht.models.MenuItem;
import com.deoudegracht.deoudegracht.models.RecipeItem;

import java.util.ArrayList;
import java.util.List;

public class RecipeResponseDTO {
    private long id;
    private String recipeName;
    private String description;
    private MenuItemResponseDTO menuItem;
    private List<RecipeItemResponseDTO> recipeItems = new ArrayList<>();

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
}
