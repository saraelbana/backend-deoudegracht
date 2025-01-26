package com.deoudegracht.deoudegracht.mappers;


import com.deoudegracht.deoudegracht.dtos.RecipeIngredientRequestDTO;
import com.deoudegracht.deoudegracht.dtos.RecipeIngredientResponseDTO;
import com.deoudegracht.deoudegracht.models.Ingredient;
import com.deoudegracht.deoudegracht.models.RecipeIngredient;

public class RecipeIngredientMapper {
    static public RecipeIngredientResponseDTO mapRecipeIngredientToRecipeIngredientResponseDTO(RecipeIngredient recipeIngredient) {
        return new RecipeIngredientResponseDTO(recipeIngredient.getId(), recipeIngredient.getIngredient().getName(), recipeIngredient.getQuantity(), recipeIngredient.getUnit());
    }
    static public RecipeIngredient mapRecipeIngredientRequestDTOToRecipeIngredient(RecipeIngredientRequestDTO recipeItemRequestDTO) {
        return new RecipeIngredient(new Ingredient(recipeItemRequestDTO.getName()), recipeItemRequestDTO.getQuantity(), recipeItemRequestDTO.getUnit());
    }
//    static public RecipeIngredient mapRecipeItemRequestDTOToRecipeItem(RecipeItemRequestDTO RecipeItemRequestDTO, long id){
//        return new RecipeIngredient(mapRecipeItemRequestDTOToRecipeItem(RecipeItemRequestDTO), id);
//    }
}