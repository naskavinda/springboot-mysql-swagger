package com.example.services;

import com.example.db.model.Book;

import java.util.List;

/**
 * Created by Kavinda on 9/12/2017.
 */
public interface BookService {
    List<Book> getAllBooks();
}
