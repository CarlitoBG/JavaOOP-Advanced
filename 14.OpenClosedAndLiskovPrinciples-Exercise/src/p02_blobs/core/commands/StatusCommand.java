package p02_blobs.core.commands;

import p02_blobs.annotations.Inject;
import p02_blobs.interfaces.Executable;
import p02_blobs.interfaces.Repository;
import p02_blobs.interfaces.Writer;
import p02_blobs.models.Blob;

public class StatusCommand implements Executable{

    @Inject
    private Repository<Blob> blobRepository;

    @Inject
    private Writer writer;

    @Override
    public void execute() {
        this.blobRepository.findAll().forEach(blob -> this.writer.writeLine(blob.toString()));
    }
}