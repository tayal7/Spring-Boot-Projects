package com.example.Grocery.GroceryStoreManagement.Controller;

import com.example.Grocery.GroceryStoreManagement.Entity.Grocery;
import com.example.Grocery.GroceryStoreManagement.Exception.GroceryNotFoundException;
import com.example.Grocery.GroceryStoreManagement.Service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class GroceryController {

    @Autowired
    private GroceryService groceryServiceObj;

    @GetMapping("/hello")
    public String hello(){
        return "Hello from STARK";
    }

    @GetMapping("/groceries")
    public Collection<Grocery> getAllGroceries()
    {
        return groceryServiceObj.getAllGroceries();
    }

    @GetMapping("/groceries/{id}")
    public Grocery getGroceryById(@PathVariable("id") int itemNumber)
    {
        return groceryServiceObj.getGroceryById(itemNumber);
    }

    @GetMapping("/groceries/exception/{id}")
    public Grocery getGroceryByIdForException(@PathVariable("id") int itemNumber)
    {
        if (itemNumber < 5 )
        {
            return groceryServiceObj.getGroceryById(itemNumber);
        }
        else
        {
            throw new GroceryNotFoundException();
        }

    }

    @DeleteMapping("/groceries/{id}")
    public void deleteGroceryById(@PathVariable("id") int itemNumber)
    {
        groceryServiceObj.deleteGroceryById(itemNumber);
    }

    @PutMapping(value = "/groceries",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateGrocery(@RequestBody Grocery g) {
        groceryServiceObj.updateGrocery(g);
    }

    @PostMapping(value = "/groceries",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertGrocery(@RequestBody Grocery g) {
        groceryServiceObj.insertGrocery(g);
        }

}
