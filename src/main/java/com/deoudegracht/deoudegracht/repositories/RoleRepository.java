package com.deoudegracht.deoudegracht.repositories;

import com.deoudegracht.deoudegracht.models.Role;
import com.deoudegracht.deoudegracht.models.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
