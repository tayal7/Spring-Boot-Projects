package com.example.Grocery.GroceryStoreManagement.Service;

import com.example.Grocery.GroceryStoreManagement.Dao.GroceryDao;
import com.example.Grocery.GroceryStoreManagement.Entity.Grocery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class GroceryService
{
    @Autowired
    private GroceryDao groceryDaoObj;

    public Collection<Grocery> getAllGroceries()
    {
        return groceryDaoObj.getAllGroceries();
    }

    public Grocery getGroceryById(int itemNumber)
    {
        return groceryDaoObj.getGroceryById(itemNumber);
    }

    public void deleteGroceryById(int itemNumber) {
        this.groceryDaoObj.deleteGroceryById(itemNumber);
    }

    public void updateGrocery(Grocery g) {
        this.groceryDaoObj.updateGrocery(g);
    }

    public void insertGrocery(Grocery grocery)
    {
        this.groceryDaoObj.insertGrocery(grocery);
    }
}
