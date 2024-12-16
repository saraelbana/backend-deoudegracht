package com.deoudegracht.deoudegracht.mappers;

import com.deoudegracht.deoudegracht.dtos.RecipeRequestDTO;
import com.deoudegracht.deoudegracht.dtos.RecipeResponseDTO;
import com.deoudegracht.deoudegracht.models.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeMapper {
//    public static RecipeResponseDTO mapRecipeToRecipeResponseDTO(Recipe recipe) {
//        RecipeResponseDTO recipeResponseDTO = new RecipeResponseDTO();
//        recipeResponseDTO.setId(recipe.getId());
//        recipeResponseDTO.setRecipeName(recipe.getRecipeName());
//        recipeResponseDTO.setDescription(recipe.getDescription());
//        for(int i = 0; i < recipe.getRecipeItems().size(); i++){
//            recipeResponseDTO.getRecipeItems().add(RecipeItemMapper.mapRecipeItemToRecipeItemResponseDTO(recipe.getRecipeItems().get(i)));
//        }
//        recipeResponseDTO.setMenuItem(MenuItemMapper.mapMenuItemToMenuItemResponseDTO(recipe.getMenuItem()));
//        return recipeResponseDTO;
//    }
//
//    public static Recipe mapRecipeRequestDTOToRecipe(RecipeRequestDTO recipeRequestDTO) {
//        Recipe recipe = new Recipe();
//        recipe.setRecipeName(recipeRequestDTO.getRecipeName());
//        recipe.setDescription(recipeRequestDTO.getDescription());
//        List<RecipeItem> recipeItemsList = new ArrayList<>();
//
//        for(int i = 0; i < recipeRequestDTO.getRecipeItems().size(); i++){
//            recipeItemsList.add(RecipeItemMapper.mapRecipeItemRequestDTOToRecipeItem(recipeRequestDTO.getRecipeItems().get(i)));
//        }
//        recipe.setRecipeItems(recipeItemsList);
//
//        return recipe;
//    }
//    public static Recipe mapRecipeRequestDTOToRecipe(RecipeRequestDTO recipeRequestDTO, long id) {
//        Recipe recipe = mapRecipeRequestDTOToRecipe(recipeRequestDTO);
//        recipe.setId(id);
//        return recipe;
//    }


}
