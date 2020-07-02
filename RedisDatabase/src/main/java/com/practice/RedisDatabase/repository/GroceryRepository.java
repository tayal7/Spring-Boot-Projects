package com.practice.RedisDatabase.repository;

import com.practice.RedisDatabase.model.Grocery;

public interface GroceryRepository {

    void save(Grocery grocery);

    Grocery find(Long id);

    void delete(Long id);

    void update(Grocery grocery);

}