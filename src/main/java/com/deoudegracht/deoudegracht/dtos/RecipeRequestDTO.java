package com.deoudegracht.deoudegracht.dtos;
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
        this.instructionsSteps = instructionsSteps;}
    @Override
    public String toString() {
        return "RecipeRequestDTO {" +
                "recipeName='" + recipeName + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", recipeIngredients=" + recipeIngredientsToString() + " " +
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
    public List<InstructionStepRequestDTO> getInstructionSteps() {
        return instructionsSteps;
    }
    public String getRecipeName() {
        return recipeName;
    }
    public String getDescription() {
        return description;
    }
    public List<RecipeIngredientRequestDTO> getRecipeIngredients() {
        return recipeIngredients;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public void setInstructionSteps(List<InstructionStepRequestDTO> instructionsSteps) {
        this.instructionsSteps = instructionsSteps;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
    public void setRecipeIngredients(List<RecipeIngredientRequestDTO> recipeItems) {
        this.recipeIngredients = recipeItems;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<InstructionStepRequestDTO> getInstructionsSteps() {
        return instructionsSteps;
    }

    public void setInstructionsSteps(List<InstructionStepRequestDTO> instructionsSteps) {
        this.instructionsSteps = instructionsSteps;
    }
}
