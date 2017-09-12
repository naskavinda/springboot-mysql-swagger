package com.example.repository;

import com.example.db.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Kavinda on 9/12/2017.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
