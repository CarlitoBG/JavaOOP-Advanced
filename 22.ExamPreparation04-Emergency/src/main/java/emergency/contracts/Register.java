package emergency.contracts;

public interface Register<T> {

    void enqueueEmergency(T emergency);

    T dequeueEmergency();

    Boolean isEmpty();

    int count();
}