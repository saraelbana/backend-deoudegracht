package com.deoudegracht.deoudegracht.servicesTests;

import com.deoudegracht.deoudegracht.DeOudegrachtApplication;
import com.deoudegracht.deoudegracht.dtos.EmployeeResponseDTO;
import com.deoudegracht.deoudegracht.dtos.RecipeResponseDTO;
import com.deoudegracht.deoudegracht.models.*;
import com.deoudegracht.deoudegracht.repositories.IngredientRepository;
import com.deoudegracht.deoudegracht.repositories.RecipeRepository;
import com.deoudegracht.deoudegracht.services.RecipeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ContextConfiguration(classes={DeOudegrachtApplication.class})
public class RecipeServiceTest {
    @Autowired
    RecipeService recipeService;

    @MockBean
    private RecipeRepository recipeRepository;

    @MockBean
    private IngredientRepository ingredientRepository;

    @Test
    public void testGetRecipeById() {
        // given
        long recipeId = 987654321L;
        Recipe recipe = new Recipe("Test Recipe", "Test Description", FoodCategoryType.Salad);
        recipe.setId(recipeId);

        // when
        Mockito.when(recipeRepository.findById(recipeId)).thenReturn(Optional.of(recipe));
        Recipe result = recipeService.getRecipeById(recipeId);

        // then
        assertEquals(recipe.getId(), result.getId());
        assertEquals(recipe.getName(), result.getName());
        verify(recipeRepository).findById(recipeId);
    }

    @Test
    public void testUpdateRecipe() {
        // given
        Recipe recipe = new Recipe("Test Recipe", "Original Description", FoodCategoryType.Salad);
        recipe.setId(987654321L);
        Recipe updatedRecipe = new Recipe("Test Recipe", "Updated Description", FoodCategoryType.Salad);
        updatedRecipe.setId(987654321L);

        // when
        Mockito.when(recipeRepository.save(any(Recipe.class))).thenReturn(updatedRecipe);
        Recipe result = recipeService.updateRecipe(updatedRecipe);

        // then
        assertEquals(updatedRecipe.getDescription(), result.getDescription());
        verify(recipeRepository).save(updatedRecipe);
    }


}
