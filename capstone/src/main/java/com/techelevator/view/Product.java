package com.techelevator.view;

public class Product {
    private String itemId;
    private String name;
    private String type;
    private double price;

    public Product(String itemId, String name, String type, double price) {
        this.itemId = itemId;
        this.name = name;
        this.type = type;
        this.price = price;
    }


    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }




}
