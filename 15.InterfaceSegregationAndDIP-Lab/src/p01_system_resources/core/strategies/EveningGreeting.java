package p01_system_resources.core.strategies;

import p01_system_resources.interfaces.GreetingStrategy;

public class EveningGreeting implements GreetingStrategy{

    @Override
    public String getGreeting() {
        return "evening";
    }
}