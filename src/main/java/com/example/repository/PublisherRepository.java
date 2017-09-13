package com.example.repository;

import com.example.db.Entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Kavinda on 9/13/2017.
 */
@Repository
public interface PublisherRepository extends JpaRepository<Publisher,Integer> {

}
