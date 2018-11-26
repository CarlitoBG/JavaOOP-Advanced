package p02_blobs.observers;

public abstract class AbstractObserver {

    protected Subject subject;

    public abstract void update();
}