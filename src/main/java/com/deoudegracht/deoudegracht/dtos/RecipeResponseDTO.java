package com.deoudegracht.deoudegracht.dtos;

import java.util.ArrayList;
import java.util.List;

public class RecipeResponseDTO {
    private long id;
    private String recipeName;
    private String description;
    private String category;
    private MenuItemResponseDTO menuItem;
    private List<InstructionStepResponseDTO> instructionSteps = new ArrayList<>();
    private List<RecipeIngredientResponseDTO> recipeIngredients = new ArrayList<>();



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
    public void setDescription(String description) {
        this.description = description;
    }
    public void setRecipeIngredients(RecipeIngredientResponseDTO recipeIngredients) {
        this.recipeIngredients.add(recipeIngredients);
    }
    public void setInstructionSteps(InstructionStepResponseDTO instructionSteps) {
        this.instructionSteps.add(instructionSteps);
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setMenuItem(MenuItemResponseDTO menuItem) {
        this.menuItem = menuItem;
    }
    public String getCategory() {
        return category;
    }
    public String getDescription() {
        return description;
    }
    public List<RecipeIngredientResponseDTO> getRecipeIngredients() {
        return recipeIngredients;
    }
    public List<InstructionStepResponseDTO> getInstructionSteps() {
        return instructionSteps;
    }

}
