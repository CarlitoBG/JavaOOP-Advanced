package p01_event_implementation.events;

public class EventNameChange {

    private String changedName;

    public EventNameChange(String changedName) {
        this.changedName = changedName;
    }

    public String getChangedName() {
        return this.changedName;
    }
}