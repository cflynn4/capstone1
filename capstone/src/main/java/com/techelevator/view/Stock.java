package com.techelevator.view;

import java.util.HashMap;
import java.util.Map;

public class Stock {

    public Map<Product , Integer> inventory = new HashMap<>();
    
    private void createInventory(){
        Product a1 = new Product("A1", "Potato Crisps", "Chip", 3.05);
        Product a2 = new Product("A2", "Stackers", "Chip", 1.45);
        Product a3 = new Product("A3", "Grain Waves", "Chip", 2.75);
        Product a4 = new Product("A4", "Cloud Popcorn", "Chip", 3.65);
        Product b1 = new Product("B1", "Moonpie", "Candy", 1.80);
        Product b2 = new Product("B2", "Cowtales", "Candy", 1.50);
        Product b3 = new Product("B3", "Wonka Bar", "Candy", 1.50);
        Product b4 = new Product("B4", "Crunchie", "Candy", 1.75);
        Product c1 = new Product("C1", "Cola", "Drink", 1.25);
        Product c2 = new Product("C2", "Dr. Salt", "Drink", 1.50);
        Product c3 = new Product("C3", "Mountain Melter", "Drink", 1.50);
        Product c4 = new Product("C4", "Heavy", "Drink", 1.50);
        Product d1 = new Product("D1", "U-Chews", "Gum", 0.85);
        Product d2 = new Product("D2", "Little League Chew", "Gum", 0.95);
        Product d3 = new Product("D3", "Chiclets", "Gum", 0.75);
        Product d4 = new Product("D4", "Triplemint", "Gum", 0.75);

        inventory.put(a1, 5);
        inventory.put(a2, 5);
        inventory.put(a3, 5);
        inventory.put(a4, 5);
        inventory.put(b1, 5);
        inventory.put(b2, 5);
        inventory.put(b3, 5);
        inventory.put(b4, 5);
        inventory.put(c1, 5);
        inventory.put(c2, 5);
        inventory.put(c3, 5);
        inventory.put(c4, 5);
        inventory.put(d1, 5);
        inventory.put(d2, 5);
        inventory.put(d3, 5);
        inventory.put(d4, 5);


    }













    //key of map is product : value int for stock(remaining)


}
