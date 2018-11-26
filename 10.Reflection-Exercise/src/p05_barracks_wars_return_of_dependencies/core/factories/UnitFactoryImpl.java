package p05_barracks_wars_return_of_dependencies.core.factories;

import p05_barracks_wars_return_of_dependencies.contracts.Unit;
import p05_barracks_wars_return_of_dependencies.contracts.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME = "p05_barracks_wars_return_of_dependencies.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
			InvocationTargetException, InstantiationException {

		Class<?> unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
		Constructor<?> constructor = unitClass.getDeclaredConstructor();

		Unit unit = (Unit) constructor.newInstance();
		return unit;
	}
}