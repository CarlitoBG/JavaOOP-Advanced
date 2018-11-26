package p01_system_resources.core;

import p01_system_resources.core.strategies.AfternoonGreeting;
import p01_system_resources.core.strategies.EveningGreeting;
import p01_system_resources.core.strategies.MorningGreeting;
import p01_system_resources.interfaces.GreetingStrategy;
import p01_system_resources.interfaces.TimeProvider;
import p01_system_resources.interfaces.Writer;

public class GreetingClock {

    private TimeProvider timeProvider;
    private Writer writer;
    private GreetingStrategy greetingStrategy;

    public GreetingClock(TimeProvider timeProvider, Writer writer) {
        this.timeProvider = timeProvider;
        this.writer = writer;
        this.setGreetingStrategy();
    }

    private void setGreetingStrategy() {
        if (this.timeProvider.getHour() < 12) {
            this.greetingStrategy = new MorningGreeting();
        } else if (this.timeProvider.getHour() < 18) {
            this.greetingStrategy = new AfternoonGreeting();
        } else {
            this.greetingStrategy = new EveningGreeting();
        }
    }

    public void greeting() {
        this.writer.println(String.format("Good %s...", this.greetingStrategy.getGreeting()));
    }
}