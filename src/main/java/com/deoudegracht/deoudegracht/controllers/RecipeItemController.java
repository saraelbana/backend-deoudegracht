package com.deoudegracht.deoudegracht.controllers;

import com.deoudegracht.deoudegracht.dtos.RecipeItemRequestDTO;
import com.deoudegracht.deoudegracht.dtos.RecipeItemResponseDTO;
import com.deoudegracht.deoudegracht.mappers.RecipeItemMapper;
import com.deoudegracht.deoudegracht.services.RecipeItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/recipe-items")
public class RecipeItemController {

    private final RecipeItemService recipeItemService;

    public RecipeItemController(RecipeItemService recipeItemService) {
        this.recipeItemService = recipeItemService;
    }

    @GetMapping
    ResponseEntity <List<RecipeItemResponseDTO>> getAllRecipeItems() {
        try {

            return ResponseEntity.ok().body(recipeItemService.getAllRecipeItems());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{id}")
    ResponseEntity<RecipeItemResponseDTO> getRecipeItemById(@PathVariable long id) {

        try{
            return ResponseEntity.ok().body(RecipeItemMapper.mapRecipeItemToRecipeItemResponseDTO(recipeItemService.getRecipeItemById(id)));
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    ResponseEntity<?> createRecipeItem(@RequestBody RecipeItemRequestDTO recipeItemRequestDTO) {
        try{
            RecipeItemResponseDTO newCreatedRecipeItemDto = recipeItemService.createRecipeItem(RecipeItemMapper.mapRecipeItemRequestDTOToRecipeItem(recipeItemRequestDTO));
            System.out.println("Hello there here we are RecipeItem with ID number" + newCreatedRecipeItemDto.getId());

            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + newCreatedRecipeItemDto.getId()).toUriString());
            return ResponseEntity.created(uri).body(newCreatedRecipeItemDto);
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body("Entered RecipeItem Data is not correct");
        }
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateRecipeItem(@PathVariable long id, @RequestBody RecipeItemRequestDTO recipeItemRequestDTO) {
        try {
            RecipeItemResponseDTO updatedRecipeItem = RecipeItemMapper.mapRecipeItemToRecipeItemResponseDTO(recipeItemService.updateRecipeItem(RecipeItemMapper.mapRecipeItemRequestDTOToRecipeItem(recipeItemRequestDTO, id)));
            return ResponseEntity.ok().body(updatedRecipeItem);
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body("RecipeItem Update failed");
        }
    }
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteRecipeItem(@PathVariable long id) {
        try {
            recipeItemService.deleteRecipeItem(id);
            return ResponseEntity.ok().body("RecipeItem with ID number " + id + " has been deleted");
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body("RecipeItem Deletion failed");
        }
    }

}
