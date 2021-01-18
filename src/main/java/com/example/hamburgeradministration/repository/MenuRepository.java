package com.example.hamburgeradministration.repository;

import com.example.hamburgeradministration.model.Menu;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends MongoRepository<Menu,String> {

}

