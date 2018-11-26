package p10_to_14_inferno_infinity.factories;

import p10_to_14_inferno_infinity.contracts.api.Weapon;
import p10_to_14_inferno_infinity.contracts.impl.Axe;
import p10_to_14_inferno_infinity.contracts.impl.Knife;
import p10_to_14_inferno_infinity.contracts.impl.Sword;

public final class WeaponFactory {
    public WeaponFactory() {
    }

    public static Weapon createAxeWeapon(String name){
        return new Axe(name);
    }

    public static Weapon createSwordWeapon(String name){
        return new Sword(name);
    }

    public static Weapon createKnifeWeapon(String name){
        return new Knife(name);
    }
}