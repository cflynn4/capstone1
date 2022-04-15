package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class MainActions {

    Map<String, List<Product>> stockSheet = new HashMap<>();
    List<Product> inventory;
    Product product = new Product();
    AuditLog audit = new AuditLog();

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
        //Ternary operator that checks if the size of the list is 0. If not, prints out the key (item ID), then name, price, and type as well as the remaining stock (how many instances are in the list)
        for(Map.Entry<String, List<Product>> kvp : stockSheet.entrySet()){
            System.out.println(kvp.getKey() + ((kvp.getValue().size() == 0) ? " Sold Out!" :  " " + kvp.getValue().get(0).getName() + " " + kvp.getValue().get(0).getPrice()+ " " + kvp.getValue().get(0).getType() + " Remaining Stock: " + kvp.getValue().size()));
        }
    }

    public void feedMoney(int addMoney){
        //Feed money pretty self-explanatory. audit.writer logs the transaction and amount to the audit log.
        String transaction = "Fed Money: ";
        if(addMoney == 1){
            balance = balance.add(new BigDecimal(1.00));
            audit.writer(transaction, new BigDecimal(1.00).setScale(2), balance);
        } else if (addMoney == 2){
            balance = balance.add(new BigDecimal(2.00));
            audit.writer(transaction, new BigDecimal(2.00).setScale(2), balance);
        } else if (addMoney == 3){
            balance = balance.add(new BigDecimal(5.00));
            audit.writer(transaction, new BigDecimal(5.00).setScale(2), balance);
        } else if (addMoney == 4){
            balance = balance.add(new BigDecimal(10.00));
            audit.writer(transaction, new BigDecimal(10.00).setScale(2), balance);
        } else if (addMoney == 5){
            balance = balance.add(new BigDecimal(20.00));
            audit.writer(transaction, new BigDecimal(20.00).setScale(2), balance);
        }
    }

    public void purchase(String selection){
        //Puchase method. First checks if user input is one of the valid choices, returns a message if not.
        if(! stockSheet.containsKey(selection)){
            System.out.println("Sorry, that product doesn't exist! Please choose a valid product ID!");
        //if the purchase is valid, it then checks if there is stock remaining, returning a message if there is not.
        } if (stockSheet.containsKey(selection)){
            if(stockSheet.get(selection).size() == 0){
                System.out.println("Sorry, the item you selected is out of stock!");
        //BigDecimal compareTo checks the two numbers given. If the initial number is larger, it returns 1. If they are the same, it returns 0.
        //If the second number (the getPrice here) is larger, it returns a -1. This is just checking to make sure the result won't be negative.
            } else if(inventory.size() >= 1){
                if(balance.compareTo(stockSheet.get(selection).get(0).getPrice()) >= 0){ //
                    balance = balance.subtract(stockSheet.get(selection).get(0).getPrice()); //This line is doing the math of subtracting from the balance.
                    Product loggedCost = stockSheet.get(selection).get(1); //These following lines are all for the audit log. Sets them the variables that can be plugged into the writer.
                    BigDecimal bigCost = loggedCost.getPrice();
                    Product productName = stockSheet.get(selection).get(0);
                    String productString = productName.getName() + " " + selection;
                    audit.writer(productString, bigCost, balance); //The audit writer previously mentioned, parameters being the variables established.
                    //This is checking the type of the product purchase. ProductType is an interface with a typeOutput method
                    //and each type has their own class that overrides this method and prints out their own unique saying.
                    if(stockSheet.get(selection).get(0).getType().equals("Chip")){
                        ChipType chipType = new ChipType();
                        chipType.typeOutput();
                    } else if(stockSheet.get(selection).get(0).getType().equals("Candy")){
                        CandyType candyType = new CandyType();
                        candyType.typeOutput();
                    } else if(stockSheet.get(selection).get(0).getType().equals("Drink")){
                        DrinkType drinkType = new DrinkType();
                        drinkType.typeOutput();
                    } else if (stockSheet.get(selection).get(0).getType().equals("Gum")){
                        GumType gumType = new GumType();
                        gumType.typeOutput();
                    }
                } else{
                    System.out.println("Please enter additional funds before making that purchase!");
                }
            }
        }
    }
    public void completeTransaction(){
        //completeTransaction is called when Finish Transaction option is chosen on the main menu page.
        //The main operations is calling the dispense change method and then adding to the audit log.
        Change thisChange = new Change();
        thisChange.dispenseChange(balance);
        audit.writer("Change Given: ", balance, new BigDecimal(0.00).setScale(2));
        System.out.println("Finished transaction!");
    }
}
