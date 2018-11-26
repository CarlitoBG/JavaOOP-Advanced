package rpg.models.specials;

import rpg.contracts.Hero;
import rpg.models.Config;

public class Heal extends AbstractSpecial {

    private int counter;

    public Heal() {}

    @Override
    public void trigger() {
        Hero owner = super.getOwner();
        if (!super.isActive()) {
            if (owner.getHealth() <= (owner.getStrength() * Config.HERO_HEALTH_MULTIPLIER) / 2) {
                this.setActive(true);
                this.counter = 1;
            }
        }

        if (super.isActive()) {
            owner.setHealth(owner.getHealth() + owner.getIntelligence());
            this.counter--;
            if (this.counter <= 0) {
                super.setActive(false);
            }
        }
    }

    @Override
    public void resetState() {
        if (this.isActive()) {
            this.setActive(false);
            this.counter = 1;
        }
    }
}