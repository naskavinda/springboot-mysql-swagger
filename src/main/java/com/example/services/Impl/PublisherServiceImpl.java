package com.example.services.Impl;

import com.example.db.Entity.Publisher;
import com.example.repository.PublisherRepository;
import com.example.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Kavinda on 9/13/2017.
 */
@Service("publisherService")
@Transactional
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;

    @Autowired
    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Publisher savePublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public List<Publisher> getAllPublisher() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher getPublisher(int id) {
        return publisherRepository.findOne(id);
    }

    @Override
    public void removePublisher(int id) {
        publisherRepository.delete(id);
    }
}
