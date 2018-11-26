package p10_to_14_inferno_infinity.contracts.impl;

import p10_to_14_inferno_infinity.enums.WeaponTypes;

public class Axe extends BaseWeapon{
    public Axe(String name) {
        super(name, WeaponTypes.AXE.getMinDamage(), WeaponTypes.AXE.getMaxDamage(), WeaponTypes.AXE.getSockets());
    }
}