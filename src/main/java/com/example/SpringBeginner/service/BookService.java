package com.example.SpringBeginner.service;

import com.example.SpringBeginner.dtobai1.InputData;
import com.example.SpringBeginner.dtobai1.ResultResponse;
import com.example.SpringBeginner.entity.Author;
import com.example.SpringBeginner.entity.Book;
import com.example.SpringBeginner.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorService authorService;
    public Book addBook(Book book, int id){
        Author author = authorService.findAuthorById(id);
        book.setAuthor(author);
        return bookRepository.save(book);
    }
    public Book findBookById(int id){
        return bookRepository.findById(id).orElse(null);
    }
    public List<Book> findAllBook(){
        return bookRepository.findAll();
    }
    public Book updateBook(Book book){
        return bookRepository.save(book);
    }
    public void deleteBookById(int id){
        bookRepository.deleteById(id);
    }





    public ResultResponse response(InputData data){
        Book book = this.findBookById(data.getBookId());
        if(book.getAuthor().getId()==data.getAuthorId()){
            return new ResultResponse(200,true);
        }else {
            return new ResultResponse(200,false);
        }
    }

}
