package com.example.hamburgeradministration.repository;

import com.example.hamburgeradministration.model.Location;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepository extends MongoRepository<Location,String> {

    List<Location> findByNameContaining(String name);

    Optional<Location> findByLocationId(String id);
}
