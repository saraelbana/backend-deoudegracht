package com.deoudegracht.deoudegracht.controllers;

import com.deoudegracht.deoudegracht.dtos.EmployeeRequestDTO;
import com.deoudegracht.deoudegracht.dtos.EmployeeResponseDTO;
import com.deoudegracht.deoudegracht.dtos.RecipeRequestDTO;
import com.deoudegracht.deoudegracht.dtos.RecipeResponseDTO;
import com.deoudegracht.deoudegracht.mappers.EmployeeMapper;
import com.deoudegracht.deoudegracht.mappers.RecipeMapper;
import com.deoudegracht.deoudegracht.services.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/recipes")
public class RecipeController {
    final private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    @GetMapping
    public ResponseEntity<List<RecipeResponseDTO>> getAllRecipes() {
        try {
            return ResponseEntity.ok().body(recipeService.getAllRecipes());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<RecipeResponseDTO> getRecipeById(@PathVariable long id) {
        try {
            return ResponseEntity.ok().body(RecipeMapper.mapRecipeToRecipeResponseDTO(recipeService.getRecipeById(id)));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    ResponseEntity<?>createRecipe(@RequestBody RecipeRequestDTO recipeRequestDTO) {

        try {

            RecipeResponseDTO newCreatedRecipeDto = recipeService.createRecipe(RecipeMapper.mapRecipeRequestDTOToRecipe(recipeRequestDTO));


            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + newCreatedRecipeDto.getId()).toUriString());

            return ResponseEntity.created(uri).body(newCreatedRecipeDto);
        }
        catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body("Recipe Creation failed");
        }
    }
    @PutMapping("/{id}")
    ResponseEntity<?> updateRecipe(@PathVariable Long id, @RequestBody RecipeRequestDTO recipeRequestDTO) {
        try{

            return ResponseEntity.ok(RecipeMapper.mapRecipeToRecipeResponseDTO(recipeService.updateRecipe(RecipeMapper.mapRecipeRequestDTOToRecipe(recipeRequestDTO, id))));
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body("Updating Recipe failed");
        }
    }
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteRecipe(@PathVariable long  id) {
        try {
            recipeService.deleteRecipe(id);
            return ResponseEntity.ok().body("Recipe deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body("Deleting Recipe failed");
        }
    }
}
