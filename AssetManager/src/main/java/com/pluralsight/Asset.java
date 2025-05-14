package com.pluralsight;

public class Asset {

    //protected means so they can possibly be accessed by our children, grand children, etc.
    //these properties stay in the family - this class and subclasses
    protected String description;
    protected String dateAcquired;
    protected double originalCost;

    //constructor
    public Asset(String description, String dateAcquired, double originalCost) {
        this.description = description;
        this.dateAcquired = dateAcquired;
        this.originalCost = originalCost;
    }

    //methods
    public double getValue() {
        // returns original cost
        return originalCost;
    }

    //getters and setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateAcquired() {
        return dateAcquired;
    }

    public void setDateAcquired(String dateAcquired) {
        this.dateAcquired = dateAcquired;
    }

    public double getOriginalCost() {
        return originalCost;
    }

    public void setOriginalCost(double originalCost) {
        this.originalCost = originalCost;
    }
}