package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class MainActionsTest {

    MainActions testActions = new MainActions();

    @Before
    public void setUp() throws Exception {
        Map<String, List<Product>> stockSheet = testActions.createInventory();
    }

    @Test
    public void createInventoryTest(){
        Map<String, List<Product>> stockSheet = testActions.createInventory();

        String expected = stockSheet.get("A1").get(1).getName();

        Assert.assertEquals("Potato Crisps", expected);
    }

    @Test
    public void feedMoneyTest() {
        testActions.feedMoney(4);
        assertEquals(new BigDecimal("10.00"), testActions.balance);
        testActions.completeTransaction();
        testActions.feedMoney(1);
        assertEquals(new BigDecimal("11.00"), testActions.balance);
        testActions.completeTransaction();
    }

    @Test
    public void purchaseAndBalanceTest() {
        testActions.feedMoney(4);
        String selection = "D1";
        testActions.purchase(selection);
        assertEquals(new BigDecimal("9.15"), testActions.balance);
        testActions.completeTransaction();
    }


    @Test
    public void endTransaction() {
        testActions.feedMoney(1);
        testActions.purchase("D1");
        testActions.completeTransaction();
        assertEquals(new BigDecimal("0.15"), testActions.balance);
    }
}

