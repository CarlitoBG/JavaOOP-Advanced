package p05_barracks_wars_return_of_dependencies;

import p05_barracks_wars_return_of_dependencies.contracts.CommandInterpreter;
import p05_barracks_wars_return_of_dependencies.contracts.Repository;
import p05_barracks_wars_return_of_dependencies.contracts.Runnable;
import p05_barracks_wars_return_of_dependencies.contracts.UnitFactory;
import p05_barracks_wars_return_of_dependencies.core.Engine;
import p05_barracks_wars_return_of_dependencies.core.factories.UnitFactoryImpl;
import p05_barracks_wars_return_of_dependencies.data.UnitRepository;
import p05_barracks_wars_return_of_dependencies.interpreters.CommandInterpreterImpl;

public class Main {

	public static void main(String[] args) {
		Repository repository = new UnitRepository();
		UnitFactory unitFactory = new UnitFactoryImpl();
		CommandInterpreter interpreter = new CommandInterpreterImpl();
		Runnable engine = new Engine(repository, unitFactory, interpreter);
		engine.run();
	}
}