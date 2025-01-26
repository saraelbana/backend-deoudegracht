package com.deoudegracht.deoudegracht.mappers;

import com.deoudegracht.deoudegracht.dtos.InstructionStepRequestDTO;
import com.deoudegracht.deoudegracht.dtos.RecipeRequestDTO;
import com.deoudegracht.deoudegracht.dtos.RecipeResponseDTO;
import com.deoudegracht.deoudegracht.models.FoodCategoryType;
import com.deoudegracht.deoudegracht.models.InstructionStep;
import com.deoudegracht.deoudegracht.models.Recipe;
import com.deoudegracht.deoudegracht.models.RecipeIngredient;

import java.util.ArrayList;
import java.util.List;

public class RecipeMapper {
    public static RecipeResponseDTO mapRecipeToRecipeResponseDTO(Recipe recipe) {
        RecipeResponseDTO recipeResponseDTO = new RecipeResponseDTO();
        recipeResponseDTO.setId(recipe.getId());
        recipeResponseDTO.setRecipeName(recipe.getName());
        recipeResponseDTO.setDescription(recipe.getDescription());
        recipeResponseDTO.setCategory(recipe.getCategory().toString());

        for (RecipeIngredient recipeIngredient : recipe.getRecipeIngredients()) {
            recipeResponseDTO.setRecipeIngredients(RecipeIngredientMapper.mapRecipeIngredientToRecipeIngredientResponseDTO(recipeIngredient));
        }
        for (InstructionStep instructionStep : recipe.getInstructionsSteps()) {
            recipeResponseDTO.setInstructionSteps(InstructionStepMapper.mapInstructionStepToInstructionStepResponseDTO(instructionStep));
        }
        return recipeResponseDTO;
    }

    public static Recipe mapRecipeRequestDTOToRecipe(RecipeRequestDTO recipeRequestDTO) {
        //public Recipe(String name, String description, FoodCategoryType category, List<RecipeIngredient> recipeIngredients, List<InstructionStep> instructionsSteps)
        Recipe recipe = new Recipe(recipeRequestDTO.getRecipeName(),recipeRequestDTO.getDescription(), FoodCategoryType.valueOf(recipeRequestDTO.getCategory()));

        List<RecipeIngredient> recipeItemsList = new ArrayList<>();
        List<InstructionStep> instructionsStepsList = new ArrayList<>();
        recipe.setRecipeIngredients(recipeItemsList);
        recipe.setRecipeInstructions(instructionsStepsList);

        for(int i = 0; i < recipeRequestDTO.getRecipeIngredients().size(); i++){
            recipeItemsList.add(RecipeIngredientMapper.mapRecipeIngredientRequestDTOToRecipeIngredient(recipeRequestDTO.getRecipeIngredients().get(i)));
        }
        recipe.setRecipeIngredients(recipeItemsList);

        // Map Instruction Steps
        for (InstructionStepRequestDTO instructionStepRequestDTO : recipeRequestDTO.getInstructionSteps()) {
            InstructionStep instructionStep = new InstructionStep();
            instructionStep.setInstruction(instructionStepRequestDTO.getInstruction());
            instructionStep.setRecipe(recipe); // Set the parent recipe
            instructionsStepsList.add(instructionStep);
        }
        recipe.setRecipeInstructions(instructionsStepsList);

        return recipe;
    }
    public static Recipe mapRecipeRequestDTOToRecipe(RecipeRequestDTO recipeRequestDTO, long id) {
        Recipe recipe = mapRecipeRequestDTOToRecipe(recipeRequestDTO);
        recipe.setId(id);
        return recipe;
    }
}
