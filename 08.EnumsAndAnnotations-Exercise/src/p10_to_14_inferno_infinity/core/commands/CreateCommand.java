package p10_to_14_inferno_infinity.core.commands;

import p10_to_14_inferno_infinity.contracts.api.Weapon;
import p10_to_14_inferno_infinity.core.BaseCommand;
import p10_to_14_inferno_infinity.factories.WeaponFactory;

public class CreateCommand extends BaseCommand {

    @Override
    public String execute() {
        Weapon weapon = null;
        switch (super.getParams()[0]){
            case "AXE":
                weapon = WeaponFactory.createAxeWeapon(super.getParams()[1]);
                break;
            case "SWORD":
                weapon = WeaponFactory.createSwordWeapon(super.getParams()[1]);
                break;
            case "KNIFE":
                weapon = WeaponFactory.createKnifeWeapon(super.getParams()[1]);
                break;
        }
        super.getWeaponRepository().add(weapon);
        return  null;
    }
}