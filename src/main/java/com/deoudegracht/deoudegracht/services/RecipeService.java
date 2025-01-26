package com.deoudegracht.deoudegracht.services;

import com.deoudegracht.deoudegracht.dtos.RecipeResponseDTO;
import com.deoudegracht.deoudegracht.models.Ingredient;
import com.deoudegracht.deoudegracht.models.InstructionStep;
import com.deoudegracht.deoudegracht.models.Recipe;
import com.deoudegracht.deoudegracht.mappers.RecipeMapper;
import com.deoudegracht.deoudegracht.models.RecipeIngredient;
import com.deoudegracht.deoudegracht.repositories.IngredientRepository;
import com.deoudegracht.deoudegracht.repositories.RecipeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    final private RecipeRepository recipeRepository;
    final private IngredientRepository ingredientRepository;
    public RecipeService(RecipeRepository recipeRepository, IngredientRepository ingredientRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
    }
    @Transactional(readOnly = true)
    public List<RecipeResponseDTO> getAllRecipes() {
        try{
            List<RecipeResponseDTO> recipeResponseDTOList = new ArrayList<>();
            List<Recipe> recipeList = recipeRepository.findAll();

            for (Recipe recipe : recipeList) {
                recipeResponseDTOList.add(RecipeMapper.mapRecipeToRecipeResponseDTO(recipe));
            }
            return recipeResponseDTOList;
        }catch (Exception e) {
            throw new RuntimeException("No recipes found");
        }
    }

    public Recipe getRecipeById(long id) {
        try {
            Optional<Recipe> recipe = recipeRepository.findById(id);
            return recipe.get();
        }catch (Exception e) {
            throw new RuntimeException("Recipe not found");
        }
    }
    public RecipeResponseDTO createRecipe(Recipe recipe) {
        try {
            for (RecipeIngredient recipeIngredient : recipe.getRecipeIngredients()) {
                // Check if the ingredient already exists
                Optional<Ingredient> existingIngredient = ingredientRepository.findByName(recipeIngredient.getIngredient().getName());
                if (existingIngredient.isPresent()) {
                    // Reuse the existing ingredient
                    recipeIngredient.setIngredient(existingIngredient.get());
                } else {
                    // Save the new ingredient
                    ingredientRepository.save(recipeIngredient.getIngredient());
                }
                recipeIngredient.setRecipe(recipe);
            }

            // Save the Recipe (will cascade to RecipeIngredient)
            recipeRepository.save(recipe);

            // Return the response
            return RecipeMapper.mapRecipeToRecipeResponseDTO(recipe);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Creating recipe process failed");
        }
    }
    public Recipe updateRecipe(Recipe recipe) {
        try {
            recipeRepository.save(recipe);
            return recipe;
        }catch (Exception e) {
            throw new RuntimeException("Updating recipe process failed");
        }
    }
    public void deleteRecipe(long id) {
        recipeRepository.findById(id).orElseThrow(() -> new RuntimeException("Recipe not found"));
        try {
            recipeRepository.deleteById(id);
        }catch (Exception e) {
            throw new RuntimeException("Deleting recipe process failed");
        }
    }
}
