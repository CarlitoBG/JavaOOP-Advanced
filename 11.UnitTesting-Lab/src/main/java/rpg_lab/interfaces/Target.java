package rpg_lab.interfaces;

public interface Target {

    void takeAttack(int attackPoints);

    int getHealth();

    int giveExperience();

    boolean isDead();

    Weapon getLoot();
}