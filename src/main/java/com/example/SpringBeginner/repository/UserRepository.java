package com.example.SpringBeginner.repository;

import com.example.SpringBeginner.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    public Optional<User> findByUsername(String name);
    public boolean existsByUsernameAndPassword(String user,String password);
    public User findByUsernameAndPassword(String user,String password );
}
