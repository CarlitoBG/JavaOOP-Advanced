package p10_to_14_inferno_infinity.core.commands;

import p10_to_14_inferno_infinity.contracts.api.Weapon;
import p10_to_14_inferno_infinity.core.BaseCommand;

import java.util.Map;

public class CompareCommand extends BaseCommand{

    @Override
    public String execute() {
        Map<String, Weapon> weapons = super.getWeaponRepository().getWeapons();
        String weapon1Name = super.getParams()[0];
        String weapon2Name = super.getParams()[1];

        if (weapons.containsKey(weapon1Name) && weapons.containsKey(weapon2Name)) {
            Weapon weapon1 = weapons.get(weapon1Name);
            Weapon weapon2 = weapons.get(weapon2Name);

            if (weapon1.compareTo(weapon2) < 0) {
                return weapon2.print();
            } else {
                return weapon1.print();
            }
        }
        return null;
    }
}