package com.pluralsight;

//create a new class that extends Assets, the Cash class
//this represents the cash that you stash away under your mattresses
public class Cash extends Asset {

    //constructor
    public Cash(String description, String dateAcquired, double originalCost) {
        super(description, dateAcquired, originalCost);
    }

    //methods

    //doesn't need any custom logic since the value of cash doesn't fluctuate
    @Override
    public double getValue() {
        return originalCost;
    }
}