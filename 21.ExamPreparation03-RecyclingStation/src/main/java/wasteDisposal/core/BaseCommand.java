package wasteDisposal.core;

import wasteDisposal.annotations.Inject;
import wasteDisposal.contracts.Executable;
import wasteDisposal.contracts.RecycleController;

import java.util.Collections;
import java.util.List;

public abstract class BaseCommand implements Executable{

    @Inject
    private List<String> params;
    @Inject
    private RecycleController recycleController;

    protected BaseCommand() { }

    protected List<String> getParams() {
        return Collections.unmodifiableList(this.params);
    }

    protected RecycleController getRecycleController() {
        return this.recycleController;
    }
}