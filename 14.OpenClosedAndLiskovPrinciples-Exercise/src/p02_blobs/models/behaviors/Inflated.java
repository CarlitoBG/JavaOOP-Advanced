package p02_blobs.models.behaviors;

import p02_blobs.models.Blob;

public class Inflated extends AbstractBehavior{

    private static final int INFLATED_HEALTH_INCREMENT = 50;
    private static final int INFLATED_HEALTH_DECREMENT = 10;

    @Override
    public void trigger(Blob source) {
        if (super.isTriggered()) {
            throw new IllegalStateException();
        }
        super.setIsTriggered();
        source.setHealth(source.getHealth() + INFLATED_HEALTH_INCREMENT);
    }

    @Override
    public void applyRecurrentEffect(Blob source) {
        if (super.toDelayRecurrentEffect()) {
            super.setToDelayRecurrentEffect();
        } else {
            source.setHealth(source.getHealth() - INFLATED_HEALTH_DECREMENT);
        }
    }
}