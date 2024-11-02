package com.deoudegracht.deoudegracht.repositories;

import com.deoudegracht.deoudegracht.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
