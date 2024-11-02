package com.deoudegracht.deoudegracht.mappers;


import com.deoudegracht.deoudegracht.dtos.RecipeItemRequestDTO;
import com.deoudegracht.deoudegracht.dtos.RecipeItemResponseDTO;
import com.deoudegracht.deoudegracht.models.RecipeItem;


public class RecipeItemMapper {
    static public RecipeItemResponseDTO mapRecipeItemToRecipeItemResponseDTO(RecipeItem recipeItem) {
        return new RecipeItemResponseDTO(recipeItem.getId(), recipeItem.getName(), recipeItem.getQuantity(), recipeItem.getUnit());
    }
    static public RecipeItem mapRecipeItemRequestDTOToRecipeItem(RecipeItemRequestDTO recipeItemRequestDTO) {
        return  new RecipeItem(recipeItemRequestDTO.getName(), recipeItemRequestDTO.getQuantity(), recipeItemRequestDTO.getUnit(),recipeItemRequestDTO.getRecipe());
    }
    static public RecipeItem mapRecipeItemRequestDTOToRecipeItem(RecipeItemRequestDTO RecipeItemRequestDTO, long id){
        return new RecipeItem(mapRecipeItemRequestDTOToRecipeItem(RecipeItemRequestDTO), id);
    }
}
