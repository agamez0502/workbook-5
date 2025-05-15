package com.pluralsight;

import java.time.Year;

//create a class using the extends keyword to basically copy all the functionality from
//the parent to the child class
public class Vehicle extends Asset {
    String makeModel;
    int year;
    int odometer;

    //constructor
    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    //methods
    @Override
    public double getValue() {

        // A car's value is determined as
        int currentYear = Year.now().getValue();
        int age = currentYear - year;
        double value = 0;

        if (age <= 3) {
            // 0-3 years old  - 3% reduced value of cost per year
            value = getOriginalCost() * Math.pow(0.97, age);
        } else if (age <= 6) {
            // 4-6 years old  - 6% reduced value of cost per year
            value = getOriginalCost() * Math.pow(0.94, age - 3) * Math.pow(0.97, 3);
        } else if (age <= 10) {
            // 7-10 years old - 8% reduced value of cost per year
            value = getOriginalCost() * Math.pow(0.92, age - 6) * Math.pow(0.94, 3) * Math.pow(0.97, 3);
        } else {
            // over 10 years old - $1000.00
            value = 1000.00;
        }
        // MINUS  reduce final value by 25% if over 100,000 miles
        //unless makeModel contains word Honda or Toyota
        if ((odometer > 100000) && !(makeModel.equalsIgnoreCase("Honda") || makeModel.equalsIgnoreCase("Toyota"))) {
            value = value * 0.75;
        }

        return value;
    }

    //getters and setters
    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }
}