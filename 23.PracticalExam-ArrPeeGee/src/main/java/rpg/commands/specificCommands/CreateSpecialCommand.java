package rpg.commands.specificCommands;

import rpg.commands.BaseCommand;

public class CreateSpecialCommand extends BaseCommand {

    @Override
    public void execute() {
        super.getBattlefield().createSpecial(super.getParams().get(0), super.getParams().get(1));
    }
}