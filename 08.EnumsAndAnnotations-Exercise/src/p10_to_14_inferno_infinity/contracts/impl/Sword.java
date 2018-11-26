package p10_to_14_inferno_infinity.contracts.impl;

import p10_to_14_inferno_infinity.enums.WeaponTypes;

public class Sword extends BaseWeapon{
    public Sword(String name) {
        super(name, WeaponTypes.SWORD.getMinDamage(), WeaponTypes.SWORD.getMaxDamage(), WeaponTypes.SWORD.getSockets());
    }
}