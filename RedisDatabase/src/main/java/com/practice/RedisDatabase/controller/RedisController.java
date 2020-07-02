package com.practice.RedisDatabase.controller;

import com.practice.RedisDatabase.model.Grocery;
import com.practice.RedisDatabase.service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private GroceryService groceryService;

    @PostMapping
    public void saveGrocery(@RequestBody Grocery grocery) {
        groceryService.save(grocery);     //----- inserting
    }
    /*
    -------- Get operation test --------
    HTTP Method : POST
    URL : http://localhost:8081/redis
    BODY :
    {
        "id" : "7"
        "name" : "pulse"
    }
    */

    @Cacheable(key="#id", value="groceries", unless = "#result.id < 10")     //----- id greater than 10 will get cached
    @GetMapping(path = "{id}")
    public Grocery getGrocery(@PathVariable("id") long id) {
        return groceryService.find(id);
    }
    /*
    -------- Get operation test --------
    HTTP Method : GET
    URL : http://localhost:8081/redis/7
    */

    @CachePut(key="#id", value="groceries")
    @PutMapping
    public Grocery update(@RequestBody Grocery grocery){
        groceryService.update(grocery);
        return grocery;
    }
    /*
    -------- Put operation test --------
    HTTP Method : PUT
    URL : http://localhost:8081/redis
    BODY :
    {
        "id" : "7"
        "name" : "pulses"
    }
    */

    @CacheEvict(key="#id", value="groceries")
    @DeleteMapping(path = "{id}")
    public void deleteGrocery(@PathVariable("id") long id)
    {
         groceryService.delete(id);
    }
    /*
    -------- Delete operation test --------
    HTTP Method : DELETE
    URL : http://localhost:8081/redis/7
    */
}

