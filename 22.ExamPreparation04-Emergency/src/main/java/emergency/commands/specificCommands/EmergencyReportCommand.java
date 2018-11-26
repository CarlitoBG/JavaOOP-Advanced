package emergency.commands.specificCommands;

import emergency.commands.BaseCommand;

public class EmergencyReportCommand extends BaseCommand {

    @Override
    public String execute() {
        return super.getManagementSystem().emergencyReport();
    }
}