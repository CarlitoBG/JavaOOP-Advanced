package p05_barracks_wars_return_of_dependencies.core.commands;

public class ReportCommand extends Command {

    @Override
    public String execute(){
        String output = super.getRepository().getStatistics();
        return output;
    }
}