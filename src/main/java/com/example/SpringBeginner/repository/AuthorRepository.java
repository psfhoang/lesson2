package com.example.SpringBeginner.repository;

import com.example.SpringBeginner.entity.Author;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
    @Query("select a from Author  a where a.name like %?1%")
    List<Author> findByNameOrderByNameAsc(String name,Sort sort);
    List<Author> findByNameOrderByNameDesc(String name);

}
