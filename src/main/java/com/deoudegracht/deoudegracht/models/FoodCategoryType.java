package com.deoudegracht.deoudegracht.models;

public enum FoodCategoryType {
    Appetizers,
    Dessert,
    MainCourse,
    Beverages,
    Salad,
    SideDish,
    OTHER;

    public String getFoodCategoryTypeName() {
        return this.name();
    }
}
