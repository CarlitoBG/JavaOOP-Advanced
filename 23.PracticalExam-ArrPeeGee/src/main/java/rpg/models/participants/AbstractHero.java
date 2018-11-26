package rpg.models.participants;

import rpg.contracts.Hero;
import rpg.contracts.Special;
import rpg.contracts.Targetable;
import rpg.models.Config;

public abstract class AbstractHero implements Hero {

    private String name;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int level;
    private double health;
    private double gold;
    private boolean isAlive;
    private Special special;

    protected AbstractHero() {
        this.setAlive(true);
        this.level = 1;
        this.setGold(Config.HERO_START_GOLD);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getStrength() {
        return this.strength;
    }

    @Override
    public void setStrength(int strength) {
        int healthDifference = (strength - this.strength) * Config.HERO_HEALTH_MULTIPLIER;
        this.strength = strength;
        this.setHealth(this.getHealth() + healthDifference);
    }

    @Override
    public int getDexterity() {
        return this.dexterity;
    }

    @Override
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    @Override
    public int getIntelligence() {
        return this.intelligence;
    }

    @Override
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public double getHealth() {
        return this.health;
    }

    @Override
    public void setHealth(double health) {
        this.health = health;
    }

    @Override
    public double getGold() {
        return this.gold;
    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }

    @Override
    public void giveReward(Targetable target){
        target.receiveReward(this.getGold());
        this.setGold(0);
    }

    @Override
    public void receiveReward(double reward){
        this.gold += reward;
    }

    @Override
    public void takeDamage(double damage) {
        this.setHealth(this.getHealth() - damage);
        if (this.getHealth() <= 0){
            this.setAlive(false);
        }
    }

    @Override
    public void levelUp() {
        this.setHealth(this.getStrength() * Config.HERO_HEALTH_MULTIPLIER);
        this.resetSpecialState();
        this.setStrength(this.getStrength() * Config.LEVEL_UP_MULTIPLIER);
        this.setDexterity(this.getDexterity() * Config.LEVEL_UP_MULTIPLIER);
        this.setIntelligence(this.getIntelligence() * Config.LEVEL_UP_MULTIPLIER);
        this.setLevel(this.getLevel() + 1);
    }

    @Override
    public Special getSpecial() {
        return this.special;
    }

    @Override
    public void setSpecial(Special special) {
        this.special = special;
        this.special.setOwner(this);
    }

    @Override
    public abstract double getDamage();

    @Override
    public abstract String attack(Targetable target);

    @Override
    public String toString() {

        return String.format("  Name: %s | Class: %s%n", this.getName(), this.getClass().getSimpleName()) +
                String.format("  Health: %.2f | Damage: %.2f%n", this.getHealth(), this.getDamage()) +
                String.format("  %d STR | %d DEX | %d INT | %.2f Gold", this.getStrength(), this.getDexterity(),
                        this.getIntelligence(), this.getGold());
    }

    private int getLevel() {
        return this.level;
    }

    private void setLevel(int level) {
        this.level = level;
    }

    private void setAlive(boolean condition){
        this.isAlive = condition;
    }

    private void setGold(double gold) {
        this.gold = gold;
    }

    private void resetSpecialState() {
        Special special = this.getSpecial();
        if (special != null) {
            special.resetState();
        }
    }

    void triggerSpecial() {
        Special special = this.getSpecial();
        if (special != null) {
            special.trigger();
        }
    }
}