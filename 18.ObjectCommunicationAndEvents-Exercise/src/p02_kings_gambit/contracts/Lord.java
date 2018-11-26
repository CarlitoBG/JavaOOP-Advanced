package p02_kings_gambit.contracts;

public interface Lord extends Attackable, Observer{
    void attachObserver(Observer observer);
    void detachObserver(Observer observer);
}