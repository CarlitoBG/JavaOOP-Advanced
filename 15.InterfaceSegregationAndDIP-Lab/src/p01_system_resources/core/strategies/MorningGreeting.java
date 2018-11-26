package p01_system_resources.core.strategies;

import p01_system_resources.interfaces.GreetingStrategy;

public class MorningGreeting implements GreetingStrategy{

    @Override
    public String getGreeting() {
        return "morning";
    }
}