package p02_blobs;

import p02_blobs.core.Engine;
import p02_blobs.interfaces.Reader;
import p02_blobs.interfaces.Repository;
import p02_blobs.interfaces.Runnable;
import p02_blobs.interfaces.Writer;
import p02_blobs.io.ConsoleInputReader;
import p02_blobs.io.ConsoleOutputWriter;
import p02_blobs.models.Blob;
import p02_blobs.observers.Subject;
import p02_blobs.repositories.BlobRepository;
import p02_blobs.utility.MutateBoolean;

public class Main {
    public static void main(String[] args) {

        Reader reader = new ConsoleInputReader();
        Writer writer = new ConsoleOutputWriter();
        Repository<Blob> blobRepository = new BlobRepository();
        Subject subject = new Subject();
        MutateBoolean mutateBoolean = new MutateBoolean(false);

        Runnable engine = new Engine(reader, writer, blobRepository, subject, mutateBoolean);

        engine.run();
    }
}