package com.deoudegracht.deoudegracht.repositories;

import com.deoudegracht.deoudegracht.models.Employee;
import com.deoudegracht.deoudegracht.models.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}
