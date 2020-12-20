package com.example.SpringBeginner.controller;

import com.example.SpringBeginner.entity.Author;
import com.example.SpringBeginner.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @RequestMapping(value = "/find-by-id",method = RequestMethod.GET)
    public Author findAuthorById(@RequestParam(value = "id") int id){
        return authorService.findAuthorById(id);
    }

    @GetMapping("/find-all")
    public List<Author> findAll(){
        return authorService.findAllAuthor();
    }

    @PostMapping("/add-author")
    public Author addAuthor(@RequestBody Author author){
        return authorService.addAuthor(author);
    }
    @DeleteMapping("/delete-by-id")
    public void deleteAuthorById(@RequestParam(value = "id") int id){
        authorService.deleteAuthorById(id);
    }
    @PutMapping("/update-author")
    public Author updateAuthor(@RequestBody Author author){
        return authorService.updateAuthor(author);

    }
}
