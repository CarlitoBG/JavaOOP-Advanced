package p01_logger.factories;

import p01_logger.enums.ReportLevel;
import p01_logger.interfaces.Appender;
import p01_logger.interfaces.Layout;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AppenderFactory {

    private static final String APPENDERS_PATH = "p01_logger.models.appenders.";

    @SuppressWarnings("unchecked")
    public static Appender create(String appenderType, Layout layout, ReportLevel reportLevel) throws NoSuchMethodException,
            ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<Appender> appenderClass = (Class<Appender>) Class.forName(APPENDERS_PATH + appenderType);
        Constructor<Appender> appenderConstructor = appenderClass.getDeclaredConstructor(Layout.class);

        Appender appender = appenderConstructor.newInstance(layout);
        appender.setReportLevel(reportLevel);

        return appender;
    }
}