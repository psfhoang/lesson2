package com.example.SpringBeginner.dtobai2;

import com.example.SpringBeginner.entity.Author;

import java.util.List;

public class Output {
    public int status;
    public int count;
    public List<Author> author;

    public Output(int status, int count, List<Author> author) {
        this.status = status;
        this.count = count;
        this.author = author;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }
}
