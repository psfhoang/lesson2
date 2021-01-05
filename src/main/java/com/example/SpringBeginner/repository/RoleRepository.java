package com.example.SpringBeginner.repository;

import com.example.SpringBeginner.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles, Integer> {
    Roles findByName(String name);
}
