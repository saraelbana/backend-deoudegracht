package com.deoudegracht.deoudegracht.repositories;

import com.deoudegracht.deoudegracht.models.Recipe;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Optional<Recipe> findByName(String name);
}
