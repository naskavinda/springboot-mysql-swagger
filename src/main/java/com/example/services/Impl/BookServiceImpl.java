package com.example.services.Impl;

import com.example.db.Entity.Book;
import com.example.repository.BookRepository;
import com.example.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Kavinda on 9/12/2017.
 */
@Service( "bookService" )
@Transactional
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(int id) {
        return bookRepository.findOne(id);
    }
}
