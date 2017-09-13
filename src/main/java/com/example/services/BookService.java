package com.example.services;

import com.example.db.Entity.Book;

import java.util.List;

/**
 * Created by Kavinda on 9/12/2017.
 */
public interface BookService {
    List<Book> getAllBooks();

    Book save(Book book);

    Book getBookById(int id);
}
