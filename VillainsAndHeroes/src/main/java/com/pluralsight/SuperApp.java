package com.pluralsight;

public class SuperApp {

    public static void main(String[] args) {

        // Create a hero object with a name, health, and powerLevel
        SuperHero hero = new SuperHero("Alondra", 100, 10);
        System.out.println(hero.name + " is a " + hero.getType());

        // Create a villain object with a name, health, and evilness
        SuperVillain villain = new SuperVillain("Andrew", 100, 5);
        System.out.println(villain.name + " is a " + villain.getType());

//        // If hero is an instance of SuperHero, say hello
//        if(hero instanceof SuperHero){
//            System.out.println("Hello");
//        }

        // Display an introduction message
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\n═══════════════════════════════════════════════════════");
        System.out.println("⚔\uFE0F Let the battle begin between " + villain.name + " and " + hero.name + " ⚔\uFE0F");
        System.out.println("═══════════════════════════════════════════════════════\n");

        // Show the starting status of both characters
        System.out.println(hero.getStatus());
        System.out.println(villain.getStatus());

        // Loop while both the hero and villain are still alive
        while (hero.health > 0 && villain.health > 0) {
            // Indicate the hero's turn
            System.out.println("\n🦸‍♀️ " + hero.name + "'s turn:");

            // Give hero some power-ups
            hero.addPowerUp("Super Speed", 5);
            hero.addPowerUp("Psychic Senses", 5);

            // Have the hero fight the villain
            hero.fight(villain);

            // Log the hit against the villain
            hero.logHit(villain);

            // Show the villain's updated status
            System.out.println(villain.getStatus());

            // If the villain is no longer alive, break the loop
            if (villain.health <= 0) {
                break;
            }

            // Indicate the villain's turn
            System.out.println("\n🦹 " + villain.name + "'s turn:");

            // Give villain some evil power-ups
            villain.addPowerUp("Telekinesis", 5);
            villain.addPowerUp("Invisibility", 4);

            // Have the villain fight the hero
            villain.fight(hero);

            // Log the hit against the hero
            villain.logHit(hero);

            // Show the hero's updated status
            System.out.println(hero.getStatus());

            // End of loop
        }

        // Display a message that the battle is over
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\n═══════════════════════════════════════════════════════");
        System.out.println("⚔\uFE0F The battle has ended between " + villain.name + " and " + hero.name + " ⚔\uFE0F");
        System.out.println("═══════════════════════════════════════════════════════\n");

        System.out.println("Stats:");
        hero.printBattleLog();
        villain.printBattleLog();


        // If the hero is still alive
        if (hero.health > 0) {
            // Announce the hero as the winner
            System.out.println("\n🦸‍ " + hero.name + " is the winner! \uD83C\uDFC6");
            // Otherwise
        } else {
            // Announce the villain as the winner
            System.out.println("\n🦹 " + villain.name + " is the winner! \uD83C\uDFC6");
        }
    }
}