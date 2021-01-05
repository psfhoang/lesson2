package com.example.SpringBeginner.controller;


import com.example.SpringBeginner.entity.Book;
import com.example.SpringBeginner.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")

public class BookController extends BaseController {
    @Autowired
    BookService bookService;
    @GetMapping("/find-by-id")
    public Book findBookById(@RequestParam(value = "id") int id){
        return bookService.findBookById(id);
    }
    @GetMapping("/find-all")
    public List<Book> findAllBook(){
        return bookService.findAllBook();
    }
    @PostMapping("/add-book")
    public Book addBook(@RequestBody Book book,@RequestParam(value = "id_author") int id){
        return bookService.addBook(book,id);
    }

    @DeleteMapping("/delete-by-id")
    public void deleteBook(@RequestParam(value = "id") int id){
        bookService.deleteBookById(id);
    }
    @PutMapping("/update-book")
    public Book updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }
//    @PostMapping("/check")
//    public ResultResponse check(@RequestBody InputData inputData){
//        return bookService.response(inputData);
//    }


}
