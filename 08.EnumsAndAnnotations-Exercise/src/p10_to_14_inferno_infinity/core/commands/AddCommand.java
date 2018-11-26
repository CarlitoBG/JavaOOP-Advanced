package p10_to_14_inferno_infinity.core.commands;

import p10_to_14_inferno_infinity.contracts.api.Weapon;
import p10_to_14_inferno_infinity.core.BaseCommand;

import java.util.Map;

public class AddCommand extends BaseCommand{

    @Override
    public String execute() {
        Map<String, Weapon> weapons = super.getWeaponRepository().getWeapons();
        String weaponName = super.getParams()[0];

        if (weapons.containsKey(weaponName)){
            int index = Integer.parseInt(super.getParams()[1]);
            String gemType = super.getParams()[2];
            weapons.get(weaponName).addGem(gemType, index);
        }
        return null;
    }
}