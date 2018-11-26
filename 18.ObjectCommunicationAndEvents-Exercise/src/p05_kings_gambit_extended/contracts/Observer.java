package p05_kings_gambit_extended.contracts;

public interface Observer {
    void update();
    String getName();
    int getHealth();
    void setHealth(int health);
}