package rpg.commands;

import rpg.annotations.Inject;
import rpg.contracts.Battlefield;
import rpg.contracts.Executable;

import java.util.Collections;
import java.util.List;

public abstract class BaseCommand implements Executable {

    @Inject
    private List<String> params;
    @Inject
    private Battlefield battlefield;

    protected BaseCommand() { }

    protected List<String> getParams() {
        return Collections.unmodifiableList(this.params);
    }

    protected Battlefield getBattlefield() {
        return this.battlefield;
    }
}