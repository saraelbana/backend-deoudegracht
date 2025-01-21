package com.deoudegracht.deoudegracht.mappers;


import com.deoudegracht.deoudegracht.dtos.RecipeIngredientRequestDTO;
import com.deoudegracht.deoudegracht.dtos.RecipeItemResponseDTO;
import com.deoudegracht.deoudegracht.models.Ingredient;
import com.deoudegracht.deoudegracht.models.RecipeIngredient;

public class RecipeIngredientMapper {
    static public RecipeItemResponseDTO mapRecipeItemToRecipeItemResponseDTO(RecipeIngredient recipeIngredient) {
        return new RecipeItemResponseDTO(recipeIngredient.getId(), recipeIngredient.getIngredient().getName(), recipeIngredient.getQuantity(), recipeIngredient.getUnit());
    }
    static public RecipeIngredient mapRecipeItemRequestDTOToRecipeItem(RecipeIngredientRequestDTO recipeItemRequestDTO) {
        return new RecipeIngredient(new Ingredient(recipeItemRequestDTO.getName()), recipeItemRequestDTO.getQuantity(), recipeItemRequestDTO.getUnit());
    }
//    static public RecipeIngredient mapRecipeItemRequestDTOToRecipeItem(RecipeItemRequestDTO RecipeItemRequestDTO, long id){
//        return new RecipeIngredient(mapRecipeItemRequestDTOToRecipeItem(RecipeItemRequestDTO), id);
//    }
}