package com.deoudegracht.deoudegracht.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(unique = true)
    private String name;

    private String description;
    @OneToOne(mappedBy = "recipe", optional = true, cascade = CascadeType.ALL)
    @JsonManagedReference
    @Nullable
    MenuItem menuItem;
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    @JsonManagedReference
    List<RecipeItem> recipeItems;

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRecipeName() {
        return name;
    }

    public void setRecipeName(String recipeName) {
        this.name = recipeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public List<RecipeItem> getRecipeItems() {
        return recipeItems;
    }

    public void setRecipeItems(List<RecipeItem> recipeItems) {
        this.recipeItems = recipeItems;
    }

    public void addRecipeItem(RecipeItem item) {
        if (this.recipeItems == null) {
            this.recipeItems = new ArrayList<>();
        }
        this.recipeItems.add(item);
        item.setRecipe(this);
    }
    public void removeRecipeItem(RecipeItem item) {
        if (this.recipeItems != null) {
            this.recipeItems.remove(item);
        }
        item.setRecipe(null);
    }
}
