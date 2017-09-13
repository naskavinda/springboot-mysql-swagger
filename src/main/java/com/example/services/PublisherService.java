package com.example.services;

import com.example.db.Entity.Publisher;

import java.util.List;

/**
 * Created by Kavinda on 9/13/2017.
 */
public interface PublisherService {

    Publisher savePublisher(Publisher publisher);

    List<Publisher> getAllPublisher();

    Publisher getPublisher(int id);

    void removePublisher(int id);
}
