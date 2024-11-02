package com.deoudegracht.deoudegracht.repositories;

import com.deoudegracht.deoudegracht.models.RecipeItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeItemRepository extends JpaRepository<RecipeItem, Long> {
}
