package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class MainActions {

    Map<String, List<Product>> stockSheet = new HashMap<>();
    //
    List<Product> inventory;
    Product product = new Product();

    BigDecimal balance = new BigDecimal(0.00).setScale(2);

    public BigDecimal getBalance() {
        return balance;
    }

    public Map<String, List<Product>> createInventory() {
        File inventoryFile = new File("vendingmachine.csv");
        try (Scanner dataInput = new Scanner(inventoryFile)) {
            //while loop takes each line, splits it to an array, then sets each part of the array as variables that are put into a new product.
            //Product is then put into a stack multiple times to indicate stock. Stack is the value of a map, where the array[0] is the key value, signifying ID.
            while (dataInput.hasNextLine()) {
                inventory = new ArrayList<>();
                String lineOfInput = dataInput.nextLine();
                String[] productAttributes = lineOfInput.split("\\|");
                String name = productAttributes[1];
                BigDecimal price = new BigDecimal(productAttributes[2]);
                String type = productAttributes[3];
                product = new Product(name, price, type);
                Collections.addAll(inventory, product, product, product, product, product);
                stockSheet.put(productAttributes[0], inventory);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Could not find file!");
        }
        return stockSheet;
    }
    public void displayInventory(){
        for(Map.Entry<String, List<Product>> kvp : stockSheet.entrySet()){
            System.out.println(kvp.getKey() + ((kvp.getValue().size() == 0) ? "Sold Out!" :  " " + kvp.getValue().get(0).getName() + " " + kvp.getValue().get(0).getPrice()+ " " + kvp.getValue().get(0).getType() + " Remaining Stock: " + kvp.getValue().size()));
        }
    }

    public void feedMoney(int addMoney){
        System.out.println("Insert amount you wish to add:");
        if(addMoney == 1){
            balance = balance.add(new BigDecimal(1.00));
        } else if (addMoney == 2){
            balance = balance.add(new BigDecimal(2.00));
        } else if (addMoney == 3){
            balance = balance.add(new BigDecimal(5.00));
        } else if (addMoney == 4){
            balance = balance.add(new BigDecimal(10.00));
        } else if (addMoney == 5){
            balance = balance.add(new BigDecimal(20.00));
        }
    }

    public void purchase(String selection){
        if(! stockSheet.containsKey(selection)){
            System.out.println("Sorry, that product doesn't exist! Please choose a valid product ID!");
        } if (stockSheet.containsKey(selection)){
            if(inventory.size() == 0){
                System.out.println("Sorry, the item you selected is out of stock!");
            } else if(inventory.size() >= 1){
                if(balance.compareTo(stockSheet.get(selection).get(0).getPrice()) >= 0){ //
                    balance = balance.subtract(stockSheet.get(selection).get(0).getPrice());
                }
            }
        }
    }
}
