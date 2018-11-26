package p03_barracks_wars_a_new_factory;

import p03_barracks_wars_a_new_factory.contracts.Repository;
import p03_barracks_wars_a_new_factory.contracts.Runnable;
import p03_barracks_wars_a_new_factory.contracts.UnitFactory;
import p03_barracks_wars_a_new_factory.core.Engine;
import p03_barracks_wars_a_new_factory.core.factories.UnitFactoryImpl;
import p03_barracks_wars_a_new_factory.data.UnitRepository;

public class Main {

	public static void main(String[] args) {
		Repository repository = new UnitRepository();
		UnitFactory unitFactory = new UnitFactoryImpl();
		Runnable engine = new Engine(repository, unitFactory);
		engine.run();
	}
}