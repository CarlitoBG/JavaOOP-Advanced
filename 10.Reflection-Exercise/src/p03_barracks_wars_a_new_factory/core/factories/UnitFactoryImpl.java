package p03_barracks_wars_a_new_factory.core.factories;

import p03_barracks_wars_a_new_factory.contracts.Unit;
import p03_barracks_wars_a_new_factory.contracts.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME = "p03_barracks_wars_a_new_factory.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
			InvocationTargetException, InstantiationException {

		Class<?> unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
		Constructor<?> constructor = unitClass.getDeclaredConstructor();

		Unit unit = (Unit) constructor.newInstance();
		return unit;
	}
}