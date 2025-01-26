package com.deoudegracht.deoudegracht.servicesTests;

import com.deoudegracht.deoudegracht.DeOudegrachtApplication;
import com.deoudegracht.deoudegracht.dtos.IngredientResponseDTO;
import com.deoudegracht.deoudegracht.models.Ingredient;
import com.deoudegracht.deoudegracht.repositories.IngredientRepository;
import com.deoudegracht.deoudegracht.services.IngredientService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ContextConfiguration(classes={DeOudegrachtApplication.class})
public class IngredientServiceTest {
    @Autowired
    IngredientService ingredientService;
    @Mock
    private IngredientRepository ingredientRepository;
    @Mock
    private Ingredient ingredient;
    @Test
    public void testCreateIngredient() {
        //given
        Ingredient ingredient = new Ingredient();
        ingredient.setName("testcreateingredient");

        // when
         Mockito.when(ingredientRepository.save(ingredient)).thenReturn(ingredient);
         IngredientResponseDTO createdIngredient = ingredientService.createIngredient(ingredient);

        //then
         assertEquals(ingredient.getName(), createdIngredient.getName());
         ingredientService.deleteIngredient(ingredient.getId());
    }
}
