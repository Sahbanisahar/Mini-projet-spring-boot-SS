package com.sahar.entities.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import com.sahar.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Role findByRole(String role);

	Optional<Role> findById(Long id);
}
