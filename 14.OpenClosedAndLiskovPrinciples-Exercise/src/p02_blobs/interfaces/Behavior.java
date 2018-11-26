package p02_blobs.interfaces;

import p02_blobs.models.Blob;

public interface Behavior {

    void trigger(Blob source);

    void applyRecurrentEffect(Blob source);

    boolean isTriggered();
}