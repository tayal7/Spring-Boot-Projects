package com.example.Grocery.GroceryStoreManagement.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Grocery")
public class Grocery
{
    @Id
    private int itemID;
    private String itemName;

    public Grocery(int itemID, String itemName)
    {
        this.itemID = itemID;
        this.itemName = itemName;
    }

    public int getItemID()
    {
        return itemID;
    }

    public void setItemID(int itemID)
    {
        this.itemID = itemID;
    }

    public String getItemName()
    {
        return itemName;
    }

    public void setItemName(String itemName)
    {
        this.itemName = itemName;
    }
}
