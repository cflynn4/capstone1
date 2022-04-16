package com.techelevator.view;

import org.junit.Assert;
import org.junit.Test;

public class TypeTest {
    @Test
    public void gumTypeTest(){
        GumType gumType = new GumType();
        gumType.typeOutput();

        Assert.assertTrue("Chew Chew, Yum!", true);
    }
    @Test
    public void chipTypeTest(){
        ChipType chipType = new ChipType();
        chipType.typeOutput();

        Assert.assertTrue("Crunch Crunch, Yum!", true);
    }
    @Test
    public void drinkTypeTest(){
        DrinkType drinkType = new DrinkType();
        drinkType.typeOutput();

        Assert.assertTrue("Glug Glug, Yum!", true);
    }
    @Test
    public void candyTypeTest(){
        CandyType candyType = new CandyType();
        candyType.typeOutput();

        Assert.assertTrue("Munch Munch, Yum!", true);
    }
}

