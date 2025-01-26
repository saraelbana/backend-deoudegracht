package com.deoudegracht.deoudegracht.dtosTests;

import com.deoudegracht.deoudegracht.dtos.FoodCategoryTypeResponseDTO;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FoodCategoryTypeResponseDTOTest {
    @Test
    public void testGetAllFoodCategoryTypes() {
        ArrayList<String> foodCategories = new ArrayList<>(Arrays.asList("Appetizers", "Dessert", "MainCourse"));
        FoodCategoryTypeResponseDTO dto = new FoodCategoryTypeResponseDTO(foodCategories);

        assertEquals(foodCategories, dto.getAllFoodCategoryTypes());
    }

    @Test
    public void testFoodCategoryTypeCounter() {
        ArrayList<String> foodCategories = new ArrayList<>(Arrays.asList("Appetizers", "Dessert", "MainCourse"));
        FoodCategoryTypeResponseDTO dto = new FoodCategoryTypeResponseDTO(foodCategories);

        assertEquals(3, dto.getAllFoodCategoryTypes().size());
    }

    @Test
    public void testEmptyFoodCategoryTypes() {
        ArrayList<String> foodCategories = new ArrayList<>();
        FoodCategoryTypeResponseDTO dto = new FoodCategoryTypeResponseDTO(foodCategories);

        assertEquals(0, dto.getAllFoodCategoryTypes().size());
    }
}
