package p01_logger.factories;

import p01_logger.interfaces.Layout;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class LayoutFactory {

    private static final String LAYOUTS_PATH = "p01_logger.models.layouts.";

    @SuppressWarnings("unchecked")
    public static Layout create(String layoutType) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {

        Class<Layout> layoutClass = (Class<Layout>) Class.forName(LAYOUTS_PATH + layoutType);
        Constructor<Layout> layoutConstructor = layoutClass.getDeclaredConstructor();

        return layoutConstructor.newInstance();
    }
}