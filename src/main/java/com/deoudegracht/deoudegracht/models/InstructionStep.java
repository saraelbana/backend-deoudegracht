package com.deoudegracht.deoudegracht.models;

import jakarta.persistence.*;

@Entity
public class InstructionStep {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private long id;
    private String instruction;
    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    public InstructionStep(String instruction, Recipe recipe) {
        this.instruction = instruction;
        this.recipe = recipe;
    }

    public InstructionStep(long id, String instruction, Recipe recipe) {
        this.id = id;
        this.instruction = instruction;
        this.recipe = recipe;
    }

    public InstructionStep() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
