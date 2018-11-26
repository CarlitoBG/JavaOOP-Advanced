package p01_system_resources.core.implementations;

import p01_system_resources.interfaces.TimeProvider;

import java.time.LocalTime;

public class TimeProviderImpl implements TimeProvider{

    @Override
    public int getHour() {
        return LocalTime.now().getHour();
    }
}