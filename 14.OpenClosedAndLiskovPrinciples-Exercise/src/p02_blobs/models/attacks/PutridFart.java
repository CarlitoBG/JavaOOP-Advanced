package p02_blobs.models.attacks;

import p02_blobs.interfaces.Attack;
import p02_blobs.models.Blob;

public class PutridFart implements Attack {

    @Override
    public void execute(Blob source, Blob target) {
        int currentHealth = target.getHealth();
        currentHealth -= source.getDamage();
        target.setHealth(currentHealth);
    }
}