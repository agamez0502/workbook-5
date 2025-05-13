package com.pluralsight;

import java.util.*;

public class SuperPerson {

    //protected means so they can possibly be accessed by our children, grand children, etc.
    //these properties stay in the family - this class and subclasses
    protected String name;
    protected int health;
    protected int experiencePoints;
    protected HashMap<String, Integer> inventory = new HashMap<>();

    //constructor
    public SuperPerson(String name, int health) {
        //take in the values for name and health
        this.name = name;
        this.health = health;

        //default the experience points to 0
        this.experiencePoints = 0;
    }

    //methods

    //hashmap
    private Map<String, Integer> battleLog = new HashMap<>();

    //method to update the log entry for our SuperPerson
    public void logHit(SuperPerson opponent) {
        String name = opponent.name;
        int count = battleLog.getOrDefault(name, 0);
        battleLog.put(name, count + 1);
    }

    //method to print the battle log for a SuperPerson
    public void printBattleLog() {
        System.out.println("Battle log for " + name + ":");
        for (Map.Entry<String, Integer> entry : battleLog.entrySet()) {
            System.out.println(" - Hit " + entry.getKey() + ": " + entry.getValue() + " times \uD83D\uDDE1\uFE0F");
        }
    }

    //method to add a power-up system to your character
    public void addPowerUp(String item, int value) {
        inventory.put(item, value);
    }

    //method to store power-ups - and randomly activate one
    public int getRandomPowerUpBonus() {
        if (!inventory.isEmpty()) {
            //create a new list of just the keys from the HashMap (glove, hammer, etc....)
            List<String> items = new ArrayList<String>(inventory.keySet());

            //get a random item name from the above list we just made and store it in randomeItem
            String randomItem = items.get(new Random().nextInt(items.size()));

            //get the point value for that item from the inventory HashMap
            //bonus would be the int that represents the damage the item will do.
            int bonus = inventory.get(randomItem);

            //print out the random activated power up
            System.out.println(this.name + " activated power-up: " + randomItem);
            return bonus;

        } else {
            //no power-up available for use
            return 0;
        }
    }

    //method to return health if our SuperPerson is alive
    public boolean isAlive() {
//        if(this.health > 0){
//            System.out.println("You are alive");
//            return true;
//        } else {
//            System.out.println("You are not alive..");
//            return false;
//        }

        //if the health is greater than zero, return true, otherwise return false
        return this.health > 0;
    }

    //method that allows us to fight another SuperPerson
    public void fight(SuperPerson opponent) {
        //generate a random amount of damage
        //this line returns a number between 0 and 20
        int damageAmount = new Random().nextInt(21);

        //print out who we are fighting
        System.out.println(this.name + " is fighting " + opponent.name);
        opponent.takeDamage(damageAmount + this.experiencePoints);
    }

    //method that allows a SuperPerson to take damage
    public void takeDamage(int damageAmount) {
        //subtract damage amount from the health
        //but we don't want to ever set our health below 0
        this.health = this.health - damageAmount; //this.health -= damageAmount
        if (this.health < 0) {
            this.health = 0;
        }
    }

    //method - a way to ask the SuperPerson how they are doing
    public String getStatus() {
        //build and return a string that tells us how the SuperPerson is doing
        return this.name + " has " + this.health + " health ❤\uFE0F left!";
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }
}