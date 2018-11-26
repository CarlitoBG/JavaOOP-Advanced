package p01_logger;

import p01_logger.core.Controller;
import p01_logger.interfaces.*;
import p01_logger.io.InputReaderImpl;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException,
            IllegalAccessException, InvocationTargetException {

        InputReader inputReader = new InputReaderImpl();
        Controller controller = new Controller(inputReader);

        controller.run();
    }
}