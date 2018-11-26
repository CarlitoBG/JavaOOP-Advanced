package rpg_lab;

import rpg_lab.interfaces.Target;
import rpg_lab.interfaces.Weapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Dummy implements Target{

    private int health;
    private int experience;
    private List<Weapon> possibleLoot;

    public Dummy(int health, int experience) {
        this.health = health;
        this.experience = experience;
        this.possibleLoot = new ArrayList<Weapon>(Arrays.asList(
                new Axe(10, 20), new Axe(20, 20), new Axe(40, 40)));
    }

    public int getHealth() {
        return this.health;
    }

    public void takeAttack(int attackPoints) {
        if (this.isDead()) {
            throw new IllegalStateException("Dummy is dead.");
        }
        this.health -= attackPoints;
    }

    public int giveExperience() {
        if (!this.isDead()) {
            throw new IllegalStateException("Target is not dead.");
        }
        return this.experience;
    }

    public boolean isDead() {
        return this.health <= 0;
    }

    public Weapon getLoot() {
        if (!isDead()) {
            return this.possibleLoot.get(new Random().nextInt(this.possibleLoot.size()));
        }
        throw new IllegalArgumentException("No loop!");
    }
}