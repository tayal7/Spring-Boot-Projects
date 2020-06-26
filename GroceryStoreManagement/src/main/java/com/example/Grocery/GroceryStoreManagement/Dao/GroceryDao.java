package com.example.Grocery.GroceryStoreManagement.Dao;

import com.example.Grocery.GroceryStoreManagement.Entity.Grocery;

import java.util.Collection;

public interface GroceryDao {
    Collection<Grocery> getAllGroceries();

    Grocery getGroceryById(int itemNumber);

    void deleteGroceryById(int itemNumber);

    void updateGrocery(Grocery groceryInfo);

    void insertGrocery(Grocery grocery);
}
