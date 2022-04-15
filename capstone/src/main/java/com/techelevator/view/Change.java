package com.techelevator.view;


public class Change {

    double balance = 0;
    double quarter = 0.25;
    double dime = 0.10;
    double nickel = 0.05;
    int quarterCounter = 0;
    int dimeCounter = 0;
    int nickelCounter = 0;

    public String dispenseChange() {

        if (balance > 0) {
            while ((balance - quarter) >= 0) {
                balance -= quarter;
                quarterCounter++;
            }
            while ((balance - dime) >= 0) {
                balance -= dime;
                dimeCounter++;
            }
            while ((balance - nickel) >= 0) {
                balance -= nickel;
                nickelCounter++;
            }
        }
        return "You receive " + nickelCounter + dimeCounter + quarterCounter;
    }
}
