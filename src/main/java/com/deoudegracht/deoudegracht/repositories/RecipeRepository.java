package com.deoudegracht.deoudegracht.repositories;

import com.deoudegracht.deoudegracht.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Optional<Object> findByName(String name);
}
