package com.pluralsight;

public interface Fightable {

    //add methods for fight, isAlive, getStatus
    void fight(SuperPerson opponent);

    boolean isAlive();

    String getStatus();
}
