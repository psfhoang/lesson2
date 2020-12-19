package com.example.SpringBeginner.service;

import com.example.SpringBeginner.entity.Author;
import com.example.SpringBeginner.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public Author addAuthor(Author author){
        return authorRepository.save(author);
    }
    public List<Author> findAllAuthor(){
        return authorRepository.findAll();
    }

    public Author findAuthorById(int id){
        return authorRepository.findById(id).orElse(null);
    }
    public void deleteAuthorById(int id){
        authorRepository.deleteById(id);
    }
    public Author updateAuthor(Author author){
        Author author1= this.findAuthorById(author.getId());
        return authorRepository.save(author);
    }



}
