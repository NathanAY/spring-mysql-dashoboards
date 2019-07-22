package com.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
