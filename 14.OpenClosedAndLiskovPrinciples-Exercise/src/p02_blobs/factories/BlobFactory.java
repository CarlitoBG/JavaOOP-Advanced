package p02_blobs.factories;

import p02_blobs.interfaces.Attack;
import p02_blobs.interfaces.Behavior;
import p02_blobs.models.Blob;
import p02_blobs.observers.Subject;

public final class BlobFactory {

    private BlobFactory() {
    }

    public static Blob create(String name, int health, int damage, Behavior behavior, Attack attack, Subject subject, boolean flag) {
        return new Blob(name, health, damage, behavior, attack, subject, flag);
    }
}