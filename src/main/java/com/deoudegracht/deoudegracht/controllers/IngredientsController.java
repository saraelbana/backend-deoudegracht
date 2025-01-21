package com.deoudegracht.deoudegracht.controllers;

import com.deoudegracht.deoudegracht.dtos.EmployeeRequestDTO;
import com.deoudegracht.deoudegracht.dtos.EmployeeResponseDTO;
import com.deoudegracht.deoudegracht.dtos.IngredientRequestDTO;
import com.deoudegracht.deoudegracht.dtos.IngredientResponseDTO;
import com.deoudegracht.deoudegracht.mappers.EmployeeMapper;
import com.deoudegracht.deoudegracht.mappers.IngredientMapper;
import com.deoudegracht.deoudegracht.services.IngredientService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/ingredients")
public class IngredientsController {
    private final IngredientService ingredientService;

    public IngredientsController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }


    @PostMapping()
    ResponseEntity<?> createIngredient(@Valid @RequestBody IngredientRequestDTO ingredientRequestDTO) {
        try {
            IngredientResponseDTO newCreatedIngredientDto = ingredientService.createIngredient(IngredientMapper.mapIngredientRequestDTOToIngredient(ingredientRequestDTO));
            System.out.println("Hello there new Ingredient is created with ID number" + newCreatedIngredientDto.getId());

            URI uri = URI.create(ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/" + newCreatedIngredientDto.getId())
                    .toUriString());

            System.out.println("Ingredient is created");
            return ResponseEntity.created(uri).body(newCreatedIngredientDto);
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }
        @GetMapping
        ResponseEntity<?> getAllIngredients() {
            try {
                return ResponseEntity.ok().body(ingredientService.getAllIngredients());

            } catch (Exception e) {
                return ResponseEntity.unprocessableEntity().body(e.getMessage());
            }
        }
}


