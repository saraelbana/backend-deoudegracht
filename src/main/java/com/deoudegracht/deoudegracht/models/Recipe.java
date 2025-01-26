package com.deoudegracht.deoudegracht.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private FoodCategoryType category;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<RecipeIngredient> recipeIngredients = new ArrayList<>();

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<InstructionStep> instructionsSteps = new ArrayList<>();

    public Recipe(String name, String description, FoodCategoryType category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.recipeIngredients = recipeIngredients;
        this.instructionsSteps = instructionsSteps;
    }

    public Recipe() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }
    public void addRecipeIngredient(RecipeIngredient recipeIngredient) {
        recipeIngredients.add(recipeIngredient);
    }
    public List<InstructionStep> getRecipeInstructions() {
        return instructionsSteps;
    }

    public void setRecipeInstructions(List<InstructionStep> instructionSteps) {
        this.instructionsSteps = instructionSteps;
    }
    public void addInstructionStep(InstructionStep instructionStep) {
        instructionsSteps.add(instructionStep);
    }
    public List<InstructionStep> getInstructionsSteps() {
        return instructionsSteps;
    }
    public FoodCategoryType getCategory() {
        return category;
    }

    public void setCategory(FoodCategoryType category) {
        this.category = category;
    }

//    public MenuItem getMenuItem() {
//        return menuItem;
//    }
//
//    public void setMenuItem(MenuItem menuItem) {
//        this.menuItem = menuItem;
//    }
}