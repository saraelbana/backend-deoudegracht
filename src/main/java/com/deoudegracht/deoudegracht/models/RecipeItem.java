package com.deoudegracht.deoudegracht.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class RecipeItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private float quantity;
    private String unit;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_id")
    @JsonBackReference
    private Recipe recipe;

    public RecipeItem() {
    }
    public RecipeItem(RecipeItem recipeItem){
        this.name = recipeItem.getName();
        this.quantity = recipeItem.getQuantity();
        this.unit = recipeItem.getUnit();
        this.recipe = recipeItem.getRecipe();
    }

    public RecipeItem(String name, float quantity, String unit, Recipe recipe) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.recipe = recipe;
    }

    public RecipeItem(RecipeItem recipeItem, long id) {
        this.id = id;
        this.name = recipeItem.getName();
        this.quantity = recipeItem.getQuantity();
        this.unit = recipeItem.getUnit();
        this.recipe = recipeItem.getRecipe();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
