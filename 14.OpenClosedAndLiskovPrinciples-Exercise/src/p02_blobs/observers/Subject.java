package p02_blobs.observers;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<AbstractObserver> observers;

    public Subject() {
        this.observers = new ArrayList<>();
    }

    public void attach(AbstractObserver observer){
        this.observers.add(observer);
    }

    public void notifyAllObservers(){
        for (AbstractObserver observer : this.observers) {
            observer.update();
        }
    }
}