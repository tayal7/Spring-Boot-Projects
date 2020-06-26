package com.example.Grocery.GroceryStoreManagement.Dao;

import com.example.Grocery.GroceryStoreManagement.Entity.Grocery;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GroceryMongoRepository extends MongoRepository<Grocery,Integer> {
}
