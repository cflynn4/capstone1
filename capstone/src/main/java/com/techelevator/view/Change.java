package com.techelevator.view;

import java.math.BigDecimal;

public class Change {


    public void dispenseChange(BigDecimal balance) {
        //dispense changes checks the balance against each change amount, subtracts that change amount, and then moves
        //on to the subsequent change amount.
        double changeBalance = (balance.doubleValue() * 100);
        int quarters = ((int) changeBalance / 25);
        changeBalance = changeBalance - (quarters * 25);
        int dime = ((int) changeBalance / 10);
        changeBalance = changeBalance - (dime * 10);
        int nickels = ((int) changeBalance / 5);
        //finally, concatenates the amount of quarters, dime and nickels into a println.
        System.out.println(
                "Your change is " + quarters + " quarter(s), " + dime + " dime(s) and " + nickels + " nickel(s). ");
    }
}

