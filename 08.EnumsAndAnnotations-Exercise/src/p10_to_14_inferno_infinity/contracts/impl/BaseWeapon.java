package p10_to_14_inferno_infinity.contracts.impl;

import p10_to_14_inferno_infinity.annotations.CustomAnnotation;
import p10_to_14_inferno_infinity.contracts.api.Weapon;
import p10_to_14_inferno_infinity.enums.GemTypes;

import java.util.Arrays;
import java.util.stream.Collectors;

@CustomAnnotation
public abstract class BaseWeapon implements Weapon, Comparable<Weapon> {
    private String name;
    private int minDamage;
    private int maxDamage;
    private GemTypes[] gems;
    private int strength;
    private int agility;
    private int vitality;

    BaseWeapon(String name, int minDamage, int maxDamage, int socketsNumber) {
        this.name = name;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.gems = new GemTypes[socketsNumber];
        this.strength = 0;
        this.agility = 0;
        this.vitality = 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addGem(String gemType, int index){
        if (index < 0 || index >= this.gems.length || !Arrays.stream(GemTypes.values()).map(GemTypes::name).collect(
                Collectors.toList()).contains(gemType.toUpperCase())){
            return;
        }

        if (this.gems[index] != null){
            this.removeGem(index);
        }

        this.gems[index] = GemTypes.valueOf(gemType.toUpperCase());

        this.strength += this.gems[index].getStrength();
        this.agility += this.gems[index].getAgility();
        this.vitality += this.gems[index].getVitality();
        this.minDamage += this.gems[index].getStrength() * 2 + this.gems[index].getAgility();
        this.maxDamage += this.gems[index].getStrength() * 3 + this.gems[index].getAgility() * 4;
    }

    @Override
    public void removeGem(int index){
        if (index < 0 || index >= this.gems.length || this.gems[index] == null){
            return;
        }

        this.strength -= this.gems[index].getStrength();
        this.agility -= this.gems[index].getAgility();
        this.vitality -= this.gems[index].getVitality();
        this.minDamage -= this.gems[index].getStrength() * 2 + this.gems[index].getAgility();
        this.maxDamage -= this.gems[index].getStrength() * 3 + this.gems[index].getAgility() * 4;

        this.gems[index] = null;
    }

    @Override
    public int compareTo(Weapon weapon) {
        return Double.compare(this.getItemLevel(), weapon.getItemLevel());
    }

    @Override
    public double getItemLevel() {
        return ((this.minDamage + this.maxDamage) / 2.0) + this.strength + this.agility + this.vitality;
    }

    @Override
    public String print(){
        return this.toString() + String.format(" (Item Level: %.1f)", this.getItemLevel());
    }

    @Override
    public String toString() {
        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality",
                this.name, minDamage, maxDamage, this.strength, this.agility, this.vitality);
    }
}