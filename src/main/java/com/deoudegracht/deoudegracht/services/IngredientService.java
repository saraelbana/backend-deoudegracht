package com.deoudegracht.deoudegracht.services;
import com.deoudegracht.deoudegracht.dtos.IngredientResponseDTO;
import com.deoudegracht.deoudegracht.mappers.IngredientMapper;
import com.deoudegracht.deoudegracht.models.Ingredient;
import com.deoudegracht.deoudegracht.repositories.IngredientRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class IngredientService {
    private final IngredientRepository ingredientRepository;
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }
    public IngredientResponseDTO createIngredient(Ingredient ingredient) {
        try {
            Ingredient savedIngredient = ingredientRepository.save(ingredient);
            return IngredientMapper.mapIngredientToIngredientResponseDTO(savedIngredient);
        } catch (Exception e) {
            throw new RuntimeException("Ingredient already exists");
        }
    }

    public List<IngredientResponseDTO> getAllIngredients() {
        try {
            List<IngredientResponseDTO> ingredientsResponseDtoList;
            List<Ingredient> ingredientsList = ingredientRepository.findAll();
            if (ingredientsList.isEmpty()) {
                throw new RuntimeException("No ingredients found");
            } else {
                ingredientsResponseDtoList = new ArrayList<>();
                for (Ingredient ingredient : ingredientsList) {
                    ingredientsResponseDtoList.add(IngredientMapper.mapIngredientToIngredientResponseDTO(ingredient));

                }
                return ingredientsResponseDtoList;
            }
        } catch (Exception e) {
            throw new RuntimeException("No Employees found");
        }
    }
}
