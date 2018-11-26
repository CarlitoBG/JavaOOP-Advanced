package p10_to_14_inferno_infinity.core;

import p10_to_14_inferno_infinity.annotations.Inject;
import p10_to_14_inferno_infinity.contracts.api.Weapon;
import p10_to_14_inferno_infinity.repositories.Repository;

public abstract class BaseCommand implements Executable {

    @Inject
    private String[] params;
    @Inject
    private Repository<Weapon> weaponRepository;

    protected BaseCommand() {
    }

    protected String[] getParams() {
        return this.params;
    }

    protected Repository<Weapon> getWeaponRepository() {
        return this.weaponRepository;
    }
}