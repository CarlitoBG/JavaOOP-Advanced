package emergency.commands.specificCommands;

import emergency.commands.BaseCommand;

public class RegisterFireServiceCenterCommand extends BaseCommand {

    @Override
    public String execute() {
        return super.getManagementSystem().registerFireServiceCenter(
                super.getParams().get(0),
                Integer.valueOf(super.getParams().get(1))
        );
    }
}