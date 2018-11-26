package emergency.commands;

import emergency.annotations.Inject;
import emergency.contracts.Executable;
import emergency.contracts.ManagementSystem;

import java.util.Collections;
import java.util.List;

public abstract class BaseCommand implements Executable{

    @Inject
    private List<String> params;
    @Inject
    private ManagementSystem managementSystem;

    protected BaseCommand() { }

    protected List<String> getParams() {
        return Collections.unmodifiableList(this.params);
    }

    protected ManagementSystem getManagementSystem() {
        return this.managementSystem;
    }
}