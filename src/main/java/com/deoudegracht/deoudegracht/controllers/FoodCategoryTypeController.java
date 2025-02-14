package com.deoudegracht.deoudegracht.controllers;

import com.deoudegracht.deoudegracht.services.FoodCategoryTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class FoodCategoryTypeController {
    private final FoodCategoryTypeService foodCategoryTypeService;

    public FoodCategoryTypeController() {
        this.foodCategoryTypeService = new FoodCategoryTypeService();
    }

    @GetMapping
    ResponseEntity<?> getAllCategories() {
        try {

            return ResponseEntity.ok().body(foodCategoryTypeService.getAllFoodCategoryTypes());
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }
}