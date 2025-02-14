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
            if(recipeRepository.findByName(recipe.getName()).isPresent()) {
                throw new RuntimeException("Recipe already exists with the name: " + recipe.getName());
            }
            saveRecipe(recipe);
            // Return the response
            return RecipeMapper.mapRecipeToRecipeResponseDTO(recipe);
        } catch (Exception e) {
            throw new RuntimeException("Creating recipe process failed");
        }
    }

    private void saveRecipe(Recipe recipe) {
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

        for (InstructionStep instructionStep : recipe.getInstructionsSteps()) {
            instructionStep.setRecipe(recipe);
        }

        // Save the Recipe (will cascade to RecipeIngredient)
        recipeRepository.save(recipe);
    }
    @Transactional
    public Recipe updateRecipe(Recipe updatedRecipe) {
        try {
            // Find the existing recipe
            Recipe existingRecipe = recipeRepository.findById(updatedRecipe.getId())
                    .orElseThrow(() -> new RuntimeException("Recipe not found"));

            // Update basic fields
            existingRecipe.setName(updatedRecipe.getName());
            existingRecipe.setDescription(updatedRecipe.getDescription());
            existingRecipe.setCategory(updatedRecipe.getCategory());

            // Create new lists for ingredients and steps
            List<RecipeIngredient> newIngredients = new ArrayList<>();
            List<InstructionStep> newSteps = new ArrayList<>();

            // Update ingredients
            for (RecipeIngredient updatedIngredient : updatedRecipe.getRecipeIngredients()) {
                Ingredient ingredient;
                
                // Check if ingredient exists
                Optional<Ingredient> existingIngredient = ingredientRepository.findByName(updatedIngredient.getIngredient().getName());
                if (existingIngredient.isPresent()) {
                    ingredient = existingIngredient.get();
                } else {
                    // Create new ingredient
                    ingredient = new Ingredient();
                    ingredient.setName(updatedIngredient.getIngredient().getName());
                    ingredientRepository.save(ingredient);
                }

                // Create new recipe ingredient association
                RecipeIngredient recipeIngredient = new RecipeIngredient();
                recipeIngredient.setIngredient(ingredient);
                recipeIngredient.setQuantity(updatedIngredient.getQuantity());
                recipeIngredient.setUnit(updatedIngredient.getUnit());
                recipeIngredient.setRecipe(existingRecipe);
                
                newIngredients.add(recipeIngredient);
            }

            // Update instruction steps
            for (InstructionStep updatedStep : updatedRecipe.getInstructionsSteps()) {
                InstructionStep step = new InstructionStep();
                step.setInstruction(updatedStep.getInstruction());
                step.setRecipe(existingRecipe);
                
                newSteps.add(step);
            }

            // Clear and set new collections
            existingRecipe.getRecipeIngredients().clear();
            existingRecipe.getInstructionsSteps().clear();
            recipeRepository.saveAndFlush(existingRecipe);

            existingRecipe.getRecipeIngredients().addAll(newIngredients);
            existingRecipe.getInstructionsSteps().addAll(newSteps);

            // Save and return the updated recipe
            return recipeRepository.saveAndFlush(existingRecipe);

        } catch (Exception e) {
            throw new RuntimeException("Updating recipe process failed: " + e.getMessage());
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
