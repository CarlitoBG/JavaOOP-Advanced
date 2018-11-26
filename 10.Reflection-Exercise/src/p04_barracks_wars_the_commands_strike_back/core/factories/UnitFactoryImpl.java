package p04_barracks_wars_the_commands_strike_back.core.factories;

import p04_barracks_wars_the_commands_strike_back.contracts.Unit;
import p04_barracks_wars_the_commands_strike_back.contracts.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME = "p04_barracks_wars_the_commands_strike_back.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
			InvocationTargetException, InstantiationException {

		Class<?> unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
		Constructor<?> constructor = unitClass.getDeclaredConstructor();

		Unit unit = (Unit) constructor.newInstance();
		return unit;
	}
}