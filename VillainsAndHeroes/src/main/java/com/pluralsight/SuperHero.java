package com.pluralsight;

import java.util.Random;

//create a class using the extends keyword to basically copy all the functionality from
//the parent to the child class
public class SuperHero extends SuperPerson {

    //constructor calls the parent class constructor
    public SuperHero(String name, int health, int powerLevel) {
        super(name, health);

        //in the parent we default power level (XP) to 0
        //for our superhero we want to have then pass in power level
        //but just use that as xp
        this.experiencePoints = powerLevel;

        //let the world know the hero now exists
        System.out.println("🦸‍♀️ " + this.name + " is here to save the day with an amazing power level of " + powerLevel + " \uD83D\uDCAA");
    }

    @Override
    public void fight(SuperPerson opponent) {
        //make the hero do a random amount of damage to the opponent
        //this line returns a number between 0 and 9
        int baseDamage = new Random().nextInt(10);

        //bonus represents the damage the random item will do
        int bonus = getRandomPowerUpBonus();

        //the damage should be a random number plus the xp(powerLevel)
        int damage = baseDamage + this.experiencePoints + bonus;

        //if the base damage (without the xp) was 0, don't do any damage and just say you missed
        if (baseDamage == 0) {
            System.out.println(this.name + " tried to do some damage \uD83D\uDCA5 to " + opponent.name + " but MISSED! \uD83D\uDEE1\uFE0F");

            //otherwise deal the damage and say something about you kicking butt against your opponent
        } else {
            System.out.println(this.name + " just kicked " + opponent.name + "'s butt!! \uD83D\uDD25\uD83D\uDC4A");
            opponent.takeDamage(damage);
            logHit(opponent);
        }
    }
}