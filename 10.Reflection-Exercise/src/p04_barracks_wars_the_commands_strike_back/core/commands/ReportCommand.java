package p04_barracks_wars_the_commands_strike_back.core.commands;

import p04_barracks_wars_the_commands_strike_back.contracts.Repository;
import p04_barracks_wars_the_commands_strike_back.contracts.UnitFactory;

public class ReportCommand extends Command{

    public ReportCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute(){
        String output = super.getRepository().getStatistics();
        return output;
    }
}