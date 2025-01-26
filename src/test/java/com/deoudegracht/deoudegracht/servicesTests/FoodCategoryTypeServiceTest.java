package com.deoudegracht.deoudegracht.servicesTests;

import com.deoudegracht.deoudegracht.dtos.FoodCategoryTypeResponseDTO;
import com.deoudegracht.deoudegracht.services.FoodCategoryTypeService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class FoodCategoryTypeServiceTest {

    @Test
    public void testGetAllFoodCategoryTypes() {
        FoodCategoryTypeService service = new FoodCategoryTypeService();
        FoodCategoryTypeResponseDTO response = service.getAllFoodCategoryTypes();

        assertEquals(6, response.getAllFoodCategoryTypes().size());
        assertEquals("Appetizers", response.getAllFoodCategoryTypes().get(0));
        assertEquals("Dessert", response.getAllFoodCategoryTypes().get(1));
        assertEquals("MainCourse", response.getAllFoodCategoryTypes().get(2));
        assertEquals("Beverages", response.getAllFoodCategoryTypes().get(3));
        assertEquals("Salad", response.getAllFoodCategoryTypes().get(4));
        assertEquals("SideDish", response.getAllFoodCategoryTypes().get(5));
    }

}
