package com.deoudegracht.deoudegracht.services;

import com.deoudegracht.deoudegracht.dtos.RecipeResponseDTO;
import com.deoudegracht.deoudegracht.models.Recipe;
import com.deoudegracht.deoudegracht.mappers.RecipeMapper;
import com.deoudegracht.deoudegracht.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
//    final private RecipeRepository recipeRepository;
//
//
//    public RecipeService(RecipeRepository recipeRepository) {
//        this.recipeRepository = recipeRepository;
//    }
//
//    public List<RecipeResponseDTO> getAllRecipes() {
//        try{
//            List<RecipeResponseDTO> recipeResponseDTOList = new ArrayList<>();
//            List<Recipe> recipeList = recipeRepository.findAll();
//            for (Recipe recipe : recipeList) {
//                recipeResponseDTOList.add(RecipeMapper.mapRecipeToRecipeResponseDTO(recipe));
//            }
//            return recipeResponseDTOList;
//        }catch (Exception e) {
//            throw new RuntimeException("No recipes found");
//        }
//    }
//    public Recipe getRecipeById(long id) {
//        try {
//            Optional<Recipe> recipe = recipeRepository.findById(id);
//            return recipe.get();
//        }catch (Exception e) {
//            throw new RuntimeException("Recipe not found");
//        }
//    }
//    public RecipeResponseDTO createRecipe(Recipe recipe) {
////        try {
////            if (recipe.getRecipeItems() != null) {
////                List<RecipeItem> recipeItems = recipe.getRecipeItems();
////                for(int i=0; i<recipe.getRecipeItems().size();i++){
////                    recipeItems.get(i).setRecipe(recipe);
////                }
////            }
////            recipeRepository.save(recipe);
////            return RecipeMapper.mapRecipeToRecipeResponseDTO(recipe);
////        }catch (Exception e) {
////            throw new RuntimeException("Creating recipe process failed");
////        }
//        return null;
//    }
//    public Recipe updateRecipe(Recipe recipe) {
//        try {
//            recipeRepository.save(recipe);
//            return recipe;
//        }catch (Exception e) {
//            throw new RuntimeException("Updating recipe process failed");
//        }
//    }
//    public void deleteRecipe(long id) {
//        recipeRepository.findById(id).orElseThrow(() -> new RuntimeException("Recipe not found"));
//        try {
//            recipeRepository.deleteById(id);
//        }catch (Exception e) {
//            throw new RuntimeException("Deleting recipe process failed");
//        }
//    }
//

}
