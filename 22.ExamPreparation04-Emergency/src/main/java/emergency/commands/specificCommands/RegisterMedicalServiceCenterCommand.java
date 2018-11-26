package emergency.commands.specificCommands;

import emergency.commands.BaseCommand;

public class RegisterMedicalServiceCenterCommand extends BaseCommand {

    @Override
    public String execute() {
        return super.getManagementSystem().registerMedicalServiceCenter(
                super.getParams().get(0),
                Integer.valueOf(super.getParams().get(1))
        );
    }
}