package emergency.commands.specificCommands;

import emergency.commands.BaseCommand;

public class ProcessEmergenciesCommand extends BaseCommand {

    @Override
    public String execute() {
        return super.getManagementSystem().processEmergencies(super.getParams().get(0));
    }
}