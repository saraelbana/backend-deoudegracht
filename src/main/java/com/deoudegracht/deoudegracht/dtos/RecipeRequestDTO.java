package com.deoudegracht.deoudegracht.dtos;

import com.deoudegracht.deoudegracht.models.FoodCategoryType;
import com.deoudegracht.deoudegracht.models.InstructionStep;

import java.util.ArrayList;
import java.util.List;

public class RecipeRequestDTO {
    private String recipeName;
    private String description;
    private String category = "OTHER";
    private List<RecipeIngredientRequestDTO> recipeIngredients = new ArrayList<>();
    private List<InstructionStepRequestDTO> instructionsSteps = new ArrayList<>();

    public RecipeRequestDTO() {
    }

    public RecipeRequestDTO(String recipeName, String description, String category, List<RecipeIngredientRequestDTO> recipeIngredients, List<InstructionStepRequestDTO> instructionsSteps) {
        this.recipeName = recipeName;
        this.description = description;
        this.category = category;
        this.recipeIngredients = recipeIngredients;
        this.instructionsSteps = instructionsSteps;
        System.out.println("hello there from the request DTO constructor" + this.toString());
    }

    @Override
    public String toString() {
        return "RecipeRequestDTO {" +
                "recipeName='" + recipeName + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", recipeIngredients=" + recipeIngredientsToString() +
                ", instructionsSteps=" + instructionsStepsToString() +
                '}' + '\'';
    }
    public String recipeIngredientsToString() {
        String recipeIngredientsString = "";
        for (RecipeIngredientRequestDTO recipeIngredient : recipeIngredients) {
            recipeIngredientsString += recipeIngredient.toString();
        }
        return recipeIngredientsString;
    }
    public String instructionsStepsToString() {
        String instructionsStepsString = "";
        for (InstructionStepRequestDTO instructionStep : instructionsSteps) {
            instructionsStepsString += instructionStep.toString();
        }
        return instructionsStepsString;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public List<InstructionStepRequestDTO> getInstructionSteps() {
        return instructionsSteps;
    }
    public void setInstructionSteps(List<InstructionStepRequestDTO> instructionsSteps) {
        this.instructionsSteps = instructionsSteps;
    }
    public String getRecipeName() {
        return recipeName;
    }
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
    public void setRecipeIngredients(List<RecipeIngredientRequestDTO> recipeItems) {
        this.recipeIngredients = recipeItems;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<RecipeIngredientRequestDTO> getRecipeIngredients() {
        return recipeIngredients;
    }
}
