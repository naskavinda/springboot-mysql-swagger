package com.example.controller;

import com.example.db.Entity.Publisher;
import com.example.services.PublisherService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Kavinda on 9/13/2017.
 */
@RestController
@RequestMapping( "/publisher" )
public class PublisherController {

    private final PublisherService publisherService;

    @Autowired
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @RequestMapping( value = "/", method = RequestMethod.POST )
    @ApiOperation( value = "Save Publisher Details" )
    public ResponseEntity<Publisher> savePublisher(@RequestBody Publisher publisher) {
        Publisher publisherResponse = publisherService.savePublisher(publisher);
        return new ResponseEntity<>(publisherResponse, HttpStatus.CREATED);
    }

    @RequestMapping( value = "/all", method = RequestMethod.GET )
    @ApiOperation( value = "Get All Publisher", response = Publisher.class, responseContainer = "List" )
    public ResponseEntity<List<Publisher>> getAllPublishers() {
        List<Publisher> publisherResponse = publisherService.getAllPublisher();
        return new ResponseEntity<>(publisherResponse, HttpStatus.OK);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.GET )
    @ApiOperation( value = "Get Publisher by given Id", response = Publisher.class )
    public ResponseEntity<Publisher> getPublisher(@RequestParam int id) {
        Publisher publisherResponse = publisherService.getPublisher(id);
        return new ResponseEntity<>(publisherResponse, HttpStatus.OK);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.DELETE )
    @ApiOperation( value = "Remove Publisher by given Id" )
    public ResponseEntity<?> removePublisher(@RequestParam int id) {
        Publisher publisher = publisherService.getPublisher(id);
        if ( publisher == null ) {
            return new ResponseEntity<>("User Not Exist. ",HttpStatus.BAD_REQUEST);
        }
        publisherService.removePublisher(id);
        return new ResponseEntity<>( "Successfully Deleted. ",HttpStatus.OK);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.PUT )
    @ApiOperation( value = "Update Publisher by given Id" )
    public ResponseEntity<?> updatePublisher(@RequestBody Publisher publisher,@RequestParam int id) {
        Publisher publisherCheck = publisherService.getPublisher(id);
        if ( publisherCheck == null ) {
            return new ResponseEntity<>("User Not Exist. ",HttpStatus.BAD_REQUEST);
        }
        publisher.setId(id);
        Publisher publisherResponse = publisherService.savePublisher(publisher);
        return new ResponseEntity<>(publisherResponse, HttpStatus.CREATED);
    }

}
