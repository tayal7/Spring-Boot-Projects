package com.example.Grocery.GroceryStoreManagement.Service;

import com.example.Grocery.GroceryStoreManagement.Dao.GroceryMongoRepository;
import com.example.Grocery.GroceryStoreManagement.Entity.Grocery;
import com.example.Grocery.GroceryStoreManagement.Exceptions.IdAlreadyExistException;
import com.example.Grocery.GroceryStoreManagement.Exceptions.NonExistingItemIdException;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroceryService
{
    @Autowired
    private GroceryMongoRepository groceryRepository;

    public List<Grocery> getAllGroceries()
    {
        return groceryRepository.findAll();
    }

    public Optional<Grocery> getGroceryById(int itemNumber) throws NonExistingItemIdException {
        if(!groceryRepository.existsById(itemNumber))
        {   throw new NonExistingItemIdException(); }
        return groceryRepository.findById(itemNumber);
    }

    public void deleteGroceryById(int itemNumber) throws NonExistingItemIdException {
        if(groceryRepository.existsById(itemNumber))
        {
            this.groceryRepository.deleteById(itemNumber);
        }
        else{
            throw new NonExistingItemIdException();
        }

    }

    public void updateGrocery(@NotNull Grocery grocery){
        if(groceryRepository.existsById(grocery.getItemID()))
        {
            groceryRepository.save(grocery);
        }
        else{
            throw new IdAlreadyExistException();
        }
    }

    public String insertGrocery(Grocery grocery)
    {
        if(groceryRepository.existsById(grocery.getItemID()))
        {
            throw new IdAlreadyExistException();
        }
        groceryRepository.save(grocery);
        return "Grocery added with id: "+grocery.getItemID();
    }
}
