package com.pluralsight;

public class SidekickDog implements Fightable {

    //add some properties to our sidekick dog
    private String name;
    private int health;
    private int barkPower;

    //constructor
    public SidekickDog(String name, int health, int barkPower) {
        this.name = name;
        this.health = health;
        this.barkPower = barkPower;
    }

    //methods

    //method to return health if our SidekickDog is alive
    public boolean isAlive() {
        //if the health is greater than zero, return true, otherwise return false
        return health > 0;
    }

    //method - a way to ask the SidekickDog how they are doing
    public String getStatus() {
        //build and return a string that tells us how the SuperPerson is doing
        return this.name + " (SidekickDog) has " + this.health + " health ❤\uFE0F left!";
    }

    @Override
    public void fight(SuperPerson opponent) {
        System.out.println("The Sidekick dog howls at the moon!");
        opponent.takeDamage(this.barkPower);
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

    public int getBarkPower() {
        return barkPower;
    }

    public void setBarkPower(int barkPower) {
        this.barkPower = barkPower;
    }
}