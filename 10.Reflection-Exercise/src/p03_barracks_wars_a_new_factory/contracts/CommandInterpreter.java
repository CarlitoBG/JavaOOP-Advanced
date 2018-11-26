package p03_barracks_wars_a_new_factory.contracts;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}