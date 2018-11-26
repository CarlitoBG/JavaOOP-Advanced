package p10_to_14_inferno_infinity.repositories;

import p10_to_14_inferno_infinity.contracts.api.Weapon;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WeaponRepository<T extends Weapon> implements Repository<Weapon>{

    private Map<String, Weapon> weapons;

    public WeaponRepository() {
        this.weapons = new HashMap<>();
    }

    @Override
    public Map<String, Weapon> getWeapons() {
        return Collections.unmodifiableMap(this.weapons);
    }

    @Override
    public void add(Weapon weapon) {
        this.weapons.putIfAbsent(weapon.getName(), weapon);
    }
}