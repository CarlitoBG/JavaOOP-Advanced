package p02_blobs.core.commands;

import p02_blobs.annotations.Inject;
import p02_blobs.interfaces.Executable;
import p02_blobs.utility.MutateBoolean;

public class ReportEventsCommand implements Executable{

    @Inject
    private MutateBoolean mutateBoolean;

    @Override
    public void execute() {
        this.mutateBoolean.setFlag(true);
    }
}