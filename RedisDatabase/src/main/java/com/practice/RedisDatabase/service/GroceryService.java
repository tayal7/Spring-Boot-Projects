package com.practice.RedisDatabase.service;

import com.practice.RedisDatabase.model.Grocery;
import com.practice.RedisDatabase.repository.GroceryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class GroceryService implements GroceryRepository {

    private static final String TABLE_NAME = "Grocery";

    private RedisTemplate<String, Object> redisTemplate;

    private HashOperations<String, Long, Grocery> hashOperations;

    @Autowired
    public GroceryService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct  //----- will be called once after the initialization
    private void intializeHashOperations() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(Grocery grocery) {
        hashOperations.put(TABLE_NAME, grocery.getId(), grocery);
    }

    @Override
    public Grocery find(Long id) {
        return hashOperations.get(TABLE_NAME, id);
    }

    @Override
    public void update(Grocery grocery){
        save(grocery);
    }

    @Override
    public void delete(Long id) {
        hashOperations.delete(TABLE_NAME,id);
    }
}