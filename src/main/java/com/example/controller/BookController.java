package com.example.controller;

import com.example.db.Entity.Book;
import com.example.services.BookService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Kavinda on 9/12/2017.
 */
@RestController
@RequestMapping( "/book" )
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping( value = "/all", method = RequestMethod.GET )
    @ApiOperation( value = "get All Books", response = Book.class, responseContainer = "List" )
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        if ( !books.isEmpty() ) {
            return new ResponseEntity(books, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping( value = "/", method = RequestMethod.POST )
    @ApiOperation( value = "Add Book Details" )
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book bookResponse = bookService.save(book);
        return new ResponseEntity<>(bookResponse, HttpStatus.CREATED);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.GET )
    @ApiOperation( value = "get Book Details By Id", response = Book.class )
    public ResponseEntity<List<Book>> getBook(@RequestParam int id) {
        Book books = bookService.getBookById(id);
        if ( books != null ) {
            return new ResponseEntity(books, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
