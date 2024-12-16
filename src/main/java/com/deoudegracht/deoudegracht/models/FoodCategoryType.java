package com.deoudegracht.deoudegracht.models;

public enum FoodCategoryType {
    Starter,
    Dessert,
    MainCourse,
    Drink,
    Salad,
    SideDish;

    public String getFoodCategoryTypeName() {
        return this.name();
    }
}
