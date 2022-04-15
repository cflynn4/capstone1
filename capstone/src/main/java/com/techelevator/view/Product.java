package com.techelevator.view;

import java.math.BigDecimal;

public class Product {
    private String name;
    private String type;
    private BigDecimal price;

    public Product(String name, BigDecimal price, String type) {
        this.name = name;
        this.type = type;
        this.price = price;
    }
    public Product(){

    }

    public String getName() {
        return name;
    }


    public String getType() {
        return type;
    }



    public BigDecimal getPrice() {
        return price;
    }

}
