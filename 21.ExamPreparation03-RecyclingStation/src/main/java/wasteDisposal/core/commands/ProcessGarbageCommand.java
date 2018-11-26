package wasteDisposal.core.commands;

import wasteDisposal.core.BaseCommand;

public class ProcessGarbageCommand extends BaseCommand {

    @Override
    public String execute() {
        return super.getRecycleController().processGarbage(
                super.getParams().get(0),
                Double.parseDouble(super.getParams().get(1)),
                Double.parseDouble(super.getParams().get(2)),
                super.getParams().get(3));
    }
}