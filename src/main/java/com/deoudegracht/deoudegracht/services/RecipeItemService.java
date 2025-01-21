package com.deoudegracht.deoudegracht.services;

import com.deoudegracht.deoudegracht.dtos.RecipeItemResponseDTO;
import com.deoudegracht.deoudegracht.mappers.RecipeIngredientMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeItemService {
//    final private RecipeItemRepository recipeItemRepository;
//
//    public RecipeItemService(RecipeItemRepository recipeItemRepository) {
//        this.recipeItemRepository = recipeItemRepository;
//    }
//
//    public List<RecipeItemResponseDTO> getAllRecipeItems() {
//        try{
//            List<RecipeItem> recipeItemsList =
//             recipeItemRepository.findAll();
//            List<RecipeItemResponseDTO> recipeItemResponseDTOList = new ArrayList<>();
//            for(RecipeItem recipeItem : recipeItemsList) {
//                recipeItemResponseDTOList.add(RecipeItemMapper.mapRecipeItemToRecipeItemResponseDTO(recipeItem));
//            }
//            return recipeItemResponseDTOList;
//        } catch (Exception e) {
//            throw new RuntimeException("Error getting all recipe items");
//        }
//    }
//    public RecipeItem getRecipeItemById(long id) {
//        try {
//            Optional<RecipeItem> recipeItem = recipeItemRepository.findById(id);
//            return recipeItem.get();
//        } catch (Exception e) {
//            throw new RuntimeException("Recipe item not found");
//        }
//    }
//    public RecipeItemResponseDTO createRecipeItem(RecipeItem recipeItem) {
//        try {
//            recipeItemRepository.save(recipeItem);
//            return RecipeItemMapper.mapRecipeItemToRecipeItemResponseDTO(recipeItem);
//        } catch (Exception e) {
//            throw new RuntimeException("Creating recipe item process failed");
//        }
//    }
//    public RecipeItem updateRecipeItem(RecipeItem recipeItem) {
//        try {
//            recipeItemRepository.save(recipeItem);
//            return recipeItem;
//        } catch (Exception e) {
//            throw new RuntimeException("Updating recipe item process failed");
//        }
//    }
//    public void deleteRecipeItem(long id) {
//        recipeItemRepository.findById(id).orElseThrow(() -> new RuntimeException("Recipe Item not found"));
//
//        try {
//            recipeItemRepository.deleteById(id);
//        } catch (Exception e) {
//            throw new RuntimeException("Deleting recipe item process failed");
//        }
//    }
}
