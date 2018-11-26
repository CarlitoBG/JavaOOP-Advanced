package rpg.commands.specificCommands;

import rpg.commands.BaseCommand;

public class StatParticipantsCommand extends BaseCommand {

    @Override
    public void execute() {
        super.getBattlefield().reportParticipants();
    }
}