package com.pluralsight;

//create a class using the extends keyword to basically copy all the functionality from
//the parent to the child class
public class House extends Asset {
    String address;
    int condition; // (1 -excellent, 2 -good, 3 -fair, 4 -poor)
    int squareFoot;
    int lotSize;

    //constructor
    public House(String description, String dateAcquired, double originalCost, String address, int condition, int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    //methods
    @Override
    public double getValue() {

        // A house's value is determined as
        double cost = 0;

        switch (condition) {
            case 1:
                // $180.00 per square foot (excellent)
                cost = 180.00;
                break;
            case 2:
                // $130.00 per square foot (good)
                cost = 130.00;
                break;
            case 3:
                // $90.00 per square foot (fair)
                cost = 90.00;
                break;
            case 4:
                // $80.00 per square foot (poor)
                cost = 80.00;
                break;
        }
        // PLUS  25 cents per square foot of lot size
        return (squareFoot * cost) + (lotSize * 0.25);
    }

    public static String getConditionInfo(int conditionRating){
        switch (conditionRating) {
            case 1:
                return "Excellente";
            case 2:
                return "Good";
            case 3:
                return "Fair";
            case 4:
                return "Poor";
            default:
                return "Unknown";
        }
    }

    //getters and setters
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }
}