package com.deoudegracht.deoudegracht.services;

import com.deoudegracht.deoudegracht.dtos.FoodCategoryTypeResponseDTO;
import com.deoudegracht.deoudegracht.models.FoodCategoryType;

import java.util.ArrayList;

public class FoodCategoryTypeService {
    public FoodCategoryTypeResponseDTO getAllFoodCategoryTypes() {
        ArrayList<String> foodCategoryTypes = new ArrayList<>();
        for (FoodCategoryType foodCategoryType : FoodCategoryType.values()) {
            if(foodCategoryType.name().equals("OTHER"))
            {}
            else
                foodCategoryTypes.add(foodCategoryType.name());
        }
        return new FoodCategoryTypeResponseDTO(foodCategoryTypes);
    }
}
