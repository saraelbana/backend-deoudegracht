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

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<RecipeIngredient> recipeIngredients = new ArrayList<>();

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<InstructionStep> instructionSteps = new ArrayList<>();

    @OneToOne(mappedBy = "recipe", optional = true, cascade = CascadeType.ALL)
    private MenuItem menuItem = new MenuItem();

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
        return instructionSteps;
    }

    public void setRecipeInstructions(List<InstructionStep> instructionSteps) {
        this.instructionSteps = instructionSteps;
    }
    public void addInstructionStep(InstructionStep instructionStep) {
        instructionSteps.add(instructionStep);
    }
    public List<InstructionStep> getInstructionSteps() {
        return instructionSteps;
    }
    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }
}
