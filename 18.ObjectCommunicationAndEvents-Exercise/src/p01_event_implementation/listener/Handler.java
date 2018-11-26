package p01_event_implementation.listener;

import p01_event_implementation.contracts.NameChangeListener;
import p01_event_implementation.events.EventNameChange;

public class Handler implements NameChangeListener {

    @Override
    public void handleChangedName(EventNameChange event) {
        System.out.println(String.format("Dispatcher's name changed to %s.", event.getChangedName()));
    }
}