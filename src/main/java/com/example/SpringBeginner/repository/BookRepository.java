package com.example.SpringBeginner.repository;


import com.example.SpringBeginner.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.Authentication;


public interface BookRepository extends JpaRepository<Book,Integer> {

}
