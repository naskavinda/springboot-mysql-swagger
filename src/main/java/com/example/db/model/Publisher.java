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
@Table(name = "publisher")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Publisher {

    @Id
    @SequenceGenerator(name = "publisher_id_seq",sequenceName = "publisher_id_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "publisher_id_seq")
    private int id;

    private String name;

    private String address;
}
