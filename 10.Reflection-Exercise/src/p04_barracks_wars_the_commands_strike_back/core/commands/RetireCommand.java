package p04_barracks_wars_the_commands_strike_back.core.commands;

import p04_barracks_wars_the_commands_strike_back.contracts.Repository;
import p04_barracks_wars_the_commands_strike_back.contracts.UnitFactory;

public class RetireCommand extends Command{
    private static final String RETIRE_MESSAGE_FORMAT = "%s retired!";

    public RetireCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute(){
        try {
            super.getRepository().removeUnit(super.getData()[1]);
        }catch (IllegalStateException ise){
            return ise.getMessage();
        }
        return String.format(RETIRE_MESSAGE_FORMAT, super.getData()[1]);
    }
}