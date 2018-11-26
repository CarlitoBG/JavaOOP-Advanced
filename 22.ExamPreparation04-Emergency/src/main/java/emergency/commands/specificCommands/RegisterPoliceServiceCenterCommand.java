package emergency.commands.specificCommands;

import emergency.commands.BaseCommand;

public class RegisterPoliceServiceCenterCommand extends BaseCommand {

    @Override
    public String execute() {
        return super.getManagementSystem().registerPoliceServiceCenter(
                super.getParams().get(0),
                Integer.valueOf(super.getParams().get(1))
        );
    }
}