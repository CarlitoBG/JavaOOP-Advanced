package p05_kings_gambit_extended.contracts;

public interface Lord extends Attackable, Observer {
    void attachObserver(Observer observer);
    void kill(String name);
}