package com.deoudegracht.deoudegracht.dtos;

import java.util.ArrayList;

public class FoodCategoryTypeResponseDTO {
    private int foodCategoryTypeCounter;
    private ArrayList<String> foodCategoryTypes;

    public FoodCategoryTypeResponseDTO(ArrayList<String> foodCategoryTypes) {
        this.foodCategoryTypes = foodCategoryTypes;
        this.foodCategoryTypeCounter = foodCategoryTypes.size();
    }
    public ArrayList<String> getAllFoodCategoryTypes() {
        return foodCategoryTypes;
    }
}
