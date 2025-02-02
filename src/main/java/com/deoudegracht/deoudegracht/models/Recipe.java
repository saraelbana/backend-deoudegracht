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
        this.name = name;
        this.description = description;
        this.category = category;
    }
    public Recipe(String name) {
        this.name = name;
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
    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }
    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }
    public void setRecipeInstructions(List<InstructionStep> instructionsSteps) {
        this.instructionsSteps = instructionsSteps;
    }
    public List<InstructionStep> getInstructionsSteps() {
        return instructionsSteps;
    }
    public FoodCategoryType getCategory() {
        return category;
    }
    public void addInstructionStep(InstructionStep instructionStep) {
        instructionsSteps.add(instructionStep);
    }
    public void setCategory(FoodCategoryType category) {
        this.category = category;
    }
    public void addRecipeIngredient(RecipeIngredient recipeIngredient) {
        recipeIngredients.add(recipeIngredient);
    }
    public List<InstructionStep> getRecipeInstructions() {
        return instructionsSteps;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}