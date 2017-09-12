package com.example.controller;

import com.example.db.model.Book;
import com.example.services.BookService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    @ApiOperation( value = "get All Books" )
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity(bookService.getAllBooks(), HttpStatus.OK);
    }
}
