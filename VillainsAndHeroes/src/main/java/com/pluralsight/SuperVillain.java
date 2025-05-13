package com.pluralsight;

import java.util.Random;

//create a class using the extends keyword to basically copy all the functionality from
//the parent to the child class
public class SuperVillain extends SuperPerson {

    //constructor calls the parent class constructor
    public SuperVillain(String name, int health, int evilness) {
        super(name, health);

        //in the parent we default evilness (XP) to 0
        //for our super villain we want to have then pass in evilness
        //but just use that as xp
        this.experiencePoints = evilness;

        //let the world know the villain now exists
        System.out.println("\n🦹 " + name + " is here to wreck the day with a stinking evilness of " + evilness + " \uD83D\uDE08");
    }

    @Override
    public void fight(SuperPerson opponent) {
        //make the villain do a random amount of damage to the opponent
        //this line returns a number between 0 and 4
        int baseDamage = new Random().nextInt(5);

        //bonus represents the damage the random item will do
        int bonus = getRandomPowerUpBonus();

        //the damage should be a random number plus the xp(powerLevel)
        int damage = baseDamage + experiencePoints + bonus;

        //if the base damage (without the xp) was 0, don't do any damage and just say you missed
        if (baseDamage == 0) {
            System.out.println(name + " tried to do some damage \uD83D\uDCA5 to " + opponent.name + " but MISSED! \uD83D\uDEE1\uFE0F");

            //otherwise deal the damage and say something about you kicking butt against your opponent
        } else {
            System.out.println(name + " just kicked " + opponent.name + "'s butt!! \uD83D\uDD25\uD83D\uDC4A");
            opponent.takeDamage(damage);
            logHit(opponent);
        }
    }
}