package rpg.commands.specificCommands;

import rpg.commands.BaseCommand;

public class StatActionsCommand extends BaseCommand {

    @Override
    public void execute() {
        super.getBattlefield().reportActions();
    }
}