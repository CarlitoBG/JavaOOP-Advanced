package rpg.contracts;

public interface Special {

    void setOwner(Hero owner);

    void trigger();

    void resetState();
}