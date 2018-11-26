package rpg;

import rpg.contracts.*;
import rpg.contracts.Runnable;
import rpg.core.BattlefieldImpl;
import rpg.engine.Engine;
import rpg.factories.ActionFactoryImpl;
import rpg.factories.SpecialFactoryImpl;
import rpg.factories.TargetableFactoryImpl;
import rpg.handlers.CommandHandlerImpl;
import rpg.io.ConsoleInputReader;
import rpg.io.ConsoleOutputWriter;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException,
            InstantiationException, IllegalAccessException, InvocationTargetException {

        Reader reader = new ConsoleInputReader();
        Writer writer = new ConsoleOutputWriter();
        ActionFactory actionFactory = new ActionFactoryImpl();
        TargetableFactory targetableFactory = new TargetableFactoryImpl();
        SpecialFactory specialFactory = new SpecialFactoryImpl();
        Battlefield battleField = new BattlefieldImpl(actionFactory, targetableFactory, specialFactory, writer);
        CommandHandler handler = new CommandHandlerImpl(battleField);
        Runnable engine = new Engine(reader, handler);

        engine.run();
    }
}