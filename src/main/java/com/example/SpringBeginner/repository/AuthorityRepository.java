package com.example.SpringBeginner.repository;

import com.example.SpringBeginner.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority,Integer > {
}
