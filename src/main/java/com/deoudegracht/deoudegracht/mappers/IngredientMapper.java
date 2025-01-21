package com.deoudegracht.deoudegracht.mappers;

import com.deoudegracht.deoudegracht.dtos.IngredientRequestDTO;
import com.deoudegracht.deoudegracht.dtos.IngredientResponseDTO;
import com.deoudegracht.deoudegracht.models.Ingredient;

public class IngredientMapper {
    static public Ingredient mapIngredientRequestDTOToIngredient(IngredientRequestDTO ingredientRequestDTO){
        return new Ingredient(ingredientRequestDTO.getName());
    }
    static public IngredientResponseDTO mapIngredientToIngredientResponseDTO(Ingredient ingredient) {
        return new IngredientResponseDTO(ingredient.getId(),ingredient.getName());
    }
}
