package p01_event_implementation.contracts;

import p01_event_implementation.events.EventNameChange;

public interface NameChangeListener {
    void handleChangedName(EventNameChange event);
}