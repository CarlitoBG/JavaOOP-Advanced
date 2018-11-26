package p10_to_14_inferno_infinity.repositories;

import p10_to_14_inferno_infinity.contracts.api.Weapon;

import java.util.Map;

public interface Repository<T> {

    Map<String, Weapon> getWeapons();

    void add(T element);
}