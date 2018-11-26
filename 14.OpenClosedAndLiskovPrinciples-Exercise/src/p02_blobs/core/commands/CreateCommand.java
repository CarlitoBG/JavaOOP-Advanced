package p02_blobs.core.commands;

import p02_blobs.annotations.Inject;
import p02_blobs.factories.AttackFactory;
import p02_blobs.factories.BehaviorFactory;
import p02_blobs.factories.BlobFactory;
import p02_blobs.interfaces.Attack;
import p02_blobs.interfaces.Behavior;
import p02_blobs.interfaces.Executable;
import p02_blobs.interfaces.Repository;
import p02_blobs.models.Blob;
import p02_blobs.observers.Subject;
import p02_blobs.utility.MutateBoolean;

public class CreateCommand implements Executable {

    @Inject
    private String[] data;

    @Inject
    private Repository<Blob> blobRepository;

    @Inject
    private Subject subject;

    @Inject
    private Boolean hasReportEvent;

    @Inject
    private MutateBoolean mutateBoolean;

    @Override
    public void execute() {
        String name = this.data[0];
        int health = Integer.parseInt(this.data[1]);
        int damage = Integer.parseInt(this.data[2]);
        String behaviorType = this.data[3];
        String attackType = this.data[4];

        Behavior behavior = BehaviorFactory.create(behaviorType);
        Attack attack = AttackFactory.create(attackType);

        Blob blob = BlobFactory.create(name, health, damage, behavior, attack, this.subject, this.mutateBoolean.getFlag());

        this.blobRepository.add(blob);
    }
}