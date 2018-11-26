package p04_barracks_wars_the_commands_strike_back;

import p04_barracks_wars_the_commands_strike_back.contracts.Repository;
import p04_barracks_wars_the_commands_strike_back.contracts.Runnable;
import p04_barracks_wars_the_commands_strike_back.contracts.UnitFactory;
import p04_barracks_wars_the_commands_strike_back.core.Engine;
import p04_barracks_wars_the_commands_strike_back.core.factories.UnitFactoryImpl;
import p04_barracks_wars_the_commands_strike_back.data.UnitRepository;
import p04_barracks_wars_the_commands_strike_back.contracts.CommandInterpreter;
import p04_barracks_wars_the_commands_strike_back.interpreters.CommandInterpreterImpl;

public class Main {

	public static void main(String[] args) {
		Repository repository = new UnitRepository();
		UnitFactory unitFactory = new UnitFactoryImpl();
		CommandInterpreter interpreter = new CommandInterpreterImpl(repository, unitFactory);
		Runnable engine = new Engine(repository, unitFactory, interpreter);
		engine.run();
	}
}