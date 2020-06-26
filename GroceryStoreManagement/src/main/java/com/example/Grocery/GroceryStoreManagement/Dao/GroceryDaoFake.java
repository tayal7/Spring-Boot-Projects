package com.example.Grocery.GroceryStoreManagement.Dao;

import com.example.Grocery.GroceryStoreManagement.Entity.Grocery;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class
GroceryDaoFake implements GroceryDao {
    private static Map<Integer, Grocery> groceries;

    static
    {
        groceries = new HashMap<Integer, Grocery>() {
            {
                put(1, new Grocery(1, "Home Essentials"));
                put(2, new Grocery(2, "Fitness Essentials"));
                put(3, new Grocery(3, "Pet Essentials"));
                put(4, new Grocery(4, "Liquid Essentials"));
            }
        };
    }

    @Override
    public Collection<Grocery> getAllGroceries()
    {
        return this.groceries.values();
    }

    @Override
    public Grocery getGroceryById(int itemNumber)
    {
        return this.groceries.get(itemNumber);
    }

    @Override
    public void deleteGroceryById(int itemNumber)
    {
        this.groceries.remove(itemNumber);
    }

    @Override
    public void updateGrocery(Grocery groceryInfo)
    {
        Grocery g;
        g = groceries.get(groceryInfo.getItemID());
        g.setItemID(groceryInfo.getItemID());
        g.setItemName(groceryInfo.getItemName());
        groceries.put(groceryInfo.getItemID(),groceryInfo);
    }

    @Override
    public void insertGrocery(Grocery grocery)
    {
        this.groceries.put(grocery.getItemID(),grocery);
    }
}
