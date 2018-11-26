package p10_to_14_inferno_infinity.contracts.impl;

import p10_to_14_inferno_infinity.enums.WeaponTypes;

public class Knife extends BaseWeapon{
    public Knife(String name) {
        super(name, WeaponTypes.KNIFE.getMinDamage(), WeaponTypes.KNIFE.getMaxDamage(), WeaponTypes.KNIFE.getSockets());
    }
}