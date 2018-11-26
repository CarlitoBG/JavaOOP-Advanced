package emergency.collection;

import emergency.contracts.Register;

public class EmergencyRegister<T> implements Register<T>{

    private static final Integer INITIAL_SIZE = 16;

    private T[] emergencyQueue;
    private Integer currentSize;
    private Integer nextIndex;

    @SuppressWarnings("unchecked")
    public EmergencyRegister() {
        this.emergencyQueue = (T[]) new Object[INITIAL_SIZE];
        this.currentSize = 0;
        this.nextIndex = 0;
    }

    @Override
    public void enqueueEmergency(T emergency) {
        this.checkIfResizeNeeded();
        this.emergencyQueue[this.nextIndex] = emergency;
        this.incrementNextIndex();
        this.incrementCurrentSize();
    }

    @Override
    public T dequeueEmergency() {
        T removedElement = this.emergencyQueue[0];

        System.arraycopy(this.emergencyQueue, 1, this.emergencyQueue, 0, this.currentSize - 1);

        this.decrementNextIndex();
        this.decrementCurrentSize();
        return removedElement;
    }

    public T peekEmergency() {
        return this.emergencyQueue[0];
    }

    @Override
    public Boolean isEmpty() {
        return this.currentSize == 0;
    }

    @Override
    public int count() {
        return this.currentSize;
    }

    private void incrementNextIndex() {
        this.nextIndex++;
    }

    private void decrementNextIndex() {
        this.nextIndex--;
    }

    private void incrementCurrentSize() {
        this.currentSize++;
    }

    private void decrementCurrentSize() {
        this.currentSize--;
    }

    private void checkIfResizeNeeded() {
        if(this.currentSize == this.emergencyQueue.length) {
            this.resize();
        }
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newArray = (T[]) new Object[2 * this.currentSize];

        System.arraycopy(this.emergencyQueue, 0, newArray, 0, this.currentSize);

        this.emergencyQueue = newArray;
    }
}