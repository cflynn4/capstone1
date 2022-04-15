package com.techelevator.view;

public class Change {

        double balance = 0;
        double quarter = 0.25;
        double dime = 0.10;
        double nickel = 0.05;
        int quarterCounter = 0;
        int dimeCounter = 0;
        int nickelCounter = 0;

        public void dispenseChange(){

            while (balance >0){
                if (balance > quarter) {
                    balance = balance -= quarter;
                    quarterCounter++;
                } else if (balance > dime){
                    balance = balance - dime;
                } else {
                    balance = balance -= nickel;
                    nickelCounter++;
                }
            }
        }
    }
}
