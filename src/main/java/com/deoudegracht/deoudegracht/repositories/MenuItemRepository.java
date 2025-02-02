package com.deoudegracht.deoudegracht.repositories;

import com.deoudegracht.deoudegracht.models.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    Optional<Object> findByName(String menuItemName);
}
