package com.samco.mongoDBSpringBoot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.samco.mongoDBSpringBoot.model.GroceryItems;

public interface GroceryRepository extends MongoRepository<GroceryItems, String> {

}
