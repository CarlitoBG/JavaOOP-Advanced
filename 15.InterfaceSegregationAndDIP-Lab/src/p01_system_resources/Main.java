package p01_system_resources;

import p01_system_resources.core.GreetingClock;
import p01_system_resources.core.implementations.ConsoleWriter;
import p01_system_resources.core.implementations.TimeProviderImpl;
import p01_system_resources.interfaces.TimeProvider;
import p01_system_resources.interfaces.Writer;

public class Main {
    public static void main(String[] args) {

        TimeProvider timeProvider = new TimeProviderImpl();
        Writer writer = new ConsoleWriter();
        GreetingClock greetingClock = new GreetingClock(timeProvider, writer);

        greetingClock.greeting();
    }
}