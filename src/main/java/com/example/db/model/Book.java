package com.example.db.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Kavinda on 9/12/2017.
 */
@Entity
@Table( name = "book" )
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @SequenceGenerator( name = "book_id_seq", sequenceName = "book_id_seq", allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.AUTO, generator = "book_id_seq" )
    private int bookId;

    private String title;

    private String available;

    private String author;

    private double price;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( referencedColumnName = "id", nullable = false )
    private Publisher publisher;
}
