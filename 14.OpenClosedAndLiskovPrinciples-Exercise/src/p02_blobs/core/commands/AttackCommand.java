package p02_blobs.core.commands;

import p02_blobs.annotations.Inject;
import p02_blobs.interfaces.Executable;
import p02_blobs.interfaces.Repository;
import p02_blobs.models.Blob;

public class AttackCommand implements Executable{

    @Inject
    private String[] data;

    @Inject
    private Repository<Blob> blobRepository;

    @Override
    public void execute() {
        String sourceName = this.data[0];
        String targetName = this.data[1];

        Blob source = this.blobRepository.getByName(sourceName);
        Blob target = this.blobRepository.getByName(targetName);

        source.attack(target);
    }
}