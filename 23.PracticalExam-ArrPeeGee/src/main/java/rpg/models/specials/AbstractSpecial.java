package rpg.models.specials;

import rpg.contracts.Hero;
import rpg.contracts.Special;

public abstract class AbstractSpecial implements Special {

    private Hero owner;
    private boolean isActive;

    AbstractSpecial() {
        this.isActive = false;
    }

    @Override
    public void setOwner(Hero owner) {
        this.owner = owner;
    }

    Hero getOwner() {
        return this.owner;
    }

    boolean isActive() {
        return this.isActive;
    }

    void setActive(boolean active) {
        this.isActive = active;
    }
}