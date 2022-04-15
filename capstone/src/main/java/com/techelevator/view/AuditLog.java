package com.techelevator.view;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class AuditLog {
    //Audit log takes the Date, Time, and the transactions and concatenates it all to a println.
    public void writer(String typeOfTransaction, BigDecimal amount, BigDecimal balance) {

        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        try (PrintWriter logWriter = new PrintWriter(new FileOutputStream("auditlog.txt", true))) {

            String printToday = today.toString();
            String printTime = now.toString().substring(0, now.toString().length() - 4);
            String printAmount = amount.toString();
            String printBalance = balance.toString();

            logWriter.println(printToday + " " + printTime + " " + String.format("%-25s", typeOfTransaction)
                    + String.format("%-10s", "$" + printAmount) + String.format("%-10s", "$" + printBalance));

        } catch (FileNotFoundException e) {
            System.out.println("Sorry, File not found!");
        }
    }
}

