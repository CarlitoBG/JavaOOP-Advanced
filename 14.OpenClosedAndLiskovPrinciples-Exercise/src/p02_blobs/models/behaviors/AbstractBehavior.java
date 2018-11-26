package p02_blobs.models.behaviors;

import p02_blobs.interfaces.Behavior;

public abstract class AbstractBehavior implements Behavior {

    private boolean isTriggered;
    private boolean toDelayRecurrentEffect;

    AbstractBehavior() {
        this.toDelayRecurrentEffect = true;
    }

    void setIsTriggered() {
        this.isTriggered = true;
    }

    boolean toDelayRecurrentEffect() {
        return this.toDelayRecurrentEffect;
    }

    void setToDelayRecurrentEffect(){
        this.toDelayRecurrentEffect = false;
    }

    @Override
    public boolean isTriggered() {
        return this.isTriggered;
    }
}