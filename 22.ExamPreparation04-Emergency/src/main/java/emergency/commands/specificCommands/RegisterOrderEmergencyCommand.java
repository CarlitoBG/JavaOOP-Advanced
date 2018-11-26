package emergency.commands.specificCommands;

import emergency.commands.BaseCommand;
import emergency.enums.EmergencyLevel;
import emergency.factories.RegistrationTimeFactory;
import emergency.utils.RegistrationTime;

public class RegisterOrderEmergencyCommand extends BaseCommand {

    @Override
    public String execute() {
        return super.getManagementSystem().registerOrderEmergency(
                super.getParams().get(0),
                EmergencyLevel.valueOf(super.getParams().get(1).toUpperCase()),
                RegistrationTimeFactory.createRegistrationTime(super.getParams().get(2)),
                super.getParams().get(3)
        );
    }
}