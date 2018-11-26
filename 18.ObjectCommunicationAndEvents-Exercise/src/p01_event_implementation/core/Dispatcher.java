package p01_event_implementation.core;

import p01_event_implementation.contracts.NameChangeListener;
import p01_event_implementation.events.EventNameChange;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {

    private String name;
    private List<NameChangeListener> nameChangeListeners;

    public Dispatcher() {
        this.nameChangeListeners = new ArrayList<>();
    }

    public void fireEvent(String name){
        this.name = name;
        EventNameChange event = new EventNameChange(name);
        this.fireNameChangeEvent(event);
    }

    public void addNameChangeListener(NameChangeListener nameChangeListener){
        this.nameChangeListeners.add(nameChangeListener);
    }

    public void removeNameChangeListener(NameChangeListener nameChangeListener){
        this.nameChangeListeners.remove(nameChangeListener);
    }

    private void fireNameChangeEvent(EventNameChange event){
        for (NameChangeListener nameChangeListener : this.nameChangeListeners) {
            nameChangeListener.handleChangedName(event);
        }
    }
}