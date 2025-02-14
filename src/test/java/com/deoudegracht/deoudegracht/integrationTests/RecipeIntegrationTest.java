package com.deoudegracht.deoudegracht.integrationTests;

import com.deoudegracht.deoudegracht.models.FoodCategoryType;
import com.deoudegracht.deoudegracht.models.Recipe;
import com.deoudegracht.deoudegracht.repositories.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class RecipeIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RecipeRepository recipeRepository;

    @Test
    @WithMockUser(authorities = "ADMIN")
    public void testGetAllRecipes() throws Exception {
        // Create a test recipe
        Recipe recipe = new Recipe();
        recipe.setName("Test Recipe");
        recipe.setDescription("Test Description");
        recipe.setCategory(FoodCategoryType.OTHER); // Set a default category
        Recipe savedRecipe = recipeRepository.save(recipe);

        // Test GET /recipes endpoint
        MvcResult result = mockMvc.perform(get("/recipes"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(1))))
                .andExpect(jsonPath("$[1].recipeName").value("Test Recipe"))
                .andReturn();

        // Additional debugging
        String contentAsString = result.getResponse().getContentAsString();
        System.out.println("Response Content: " + contentAsString);

    }

    @Test
    @WithMockUser(authorities = "ADMIN")
    public void testCreateRecipe() throws Exception {
        String newRecipe = """
                {
                    "recipeName": "New Test Recipe",
                    "description": "New Test Description",
                    "preparationTime": 30,
                    "ingredients": [],
                    "category": "OTHER"
                }""";

        MvcResult result = mockMvc.perform(post("/recipes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newRecipe))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.recipeName").value("New Test Recipe"))
                .andReturn();

        // Debug output
        System.out.println("Create Response: " + result.getResponse().getContentAsString());
    }


    @Test
    @WithMockUser(authorities = "ADMIN")
    public void testDeleteRecipe() throws Exception {
        // Create a test recipe
        Recipe recipe = new Recipe();
        recipe.setName("Recipe to Delete");
        recipe.setDescription("Will be deleted");
        Recipe savedRecipe = recipeRepository.save(recipe);

        // Test DELETE /recipes/{id} endpoint
        mockMvc.perform(delete("/recipes/" + savedRecipe.getId()))
                .andExpect(status().isOk());

        // Verify the recipe is deleted
        mockMvc.perform(get("/recipes/" + savedRecipe.getId()))
                .andExpect(status().isNotFound());
    }
}
