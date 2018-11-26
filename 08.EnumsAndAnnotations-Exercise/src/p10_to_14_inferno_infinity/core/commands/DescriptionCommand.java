package p10_to_14_inferno_infinity.core.commands;

import p10_to_14_inferno_infinity.annotations.CustomAnnotation;
import p10_to_14_inferno_infinity.contracts.impl.BaseWeapon;
import p10_to_14_inferno_infinity.core.BaseCommand;

public class DescriptionCommand extends BaseCommand{

    @Override
    public String execute() {
        CustomAnnotation annotation = BaseWeapon.class.getAnnotation(CustomAnnotation.class);
        if (annotation != null) {
            return String.format("Class description: %s", annotation.description());
        }
        return null;
    }
}