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

        for(int i = 0; i < recipe.getRecipeIngredients().size(); i++){
            recipeResponseDTO.getRecipeItems().add(RecipeIngredientMapper.mapRecipeItemToRecipeItemResponseDTO(recipe.getRecipeIngredients().get(i)));
        }
        for(int i = 0; i < recipe.getInstructionsSteps().size(); i++){
            recipeResponseDTO.getInstructionSteps().add(recipe.getInstructionsSteps().get(i).getInstruction());
        }
        //recipeResponseDTO.setMenuItem(MenuItemMapper.mapMenuItemToMenuItemResponseDTO(recipe.getMenuItem()));
        return recipeResponseDTO;
    }

    public static Recipe mapRecipeRequestDTOToRecipe(RecipeRequestDTO recipeRequestDTO) {
        Recipe recipe = new Recipe();
        recipe.setName(recipeRequestDTO.getRecipeName());
        recipe.setDescription(recipeRequestDTO.getDescription());
        recipe.setCategory(FoodCategoryType.valueOf(recipeRequestDTO.getCategory()));

        List<RecipeIngredient> recipeItemsList = new ArrayList<>();
        List<InstructionStep> instructionsStepsList = new ArrayList<>();

        for(int i = 0; i < recipeRequestDTO.getRecipeIngredients().size(); i++){
            recipeItemsList.add(RecipeIngredientMapper.mapRecipeItemRequestDTOToRecipeItem(recipeRequestDTO.getRecipeIngredients().get(i)));
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
