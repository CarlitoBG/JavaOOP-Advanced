package wasteDisposal.core.commands;

import wasteDisposal.core.BaseCommand;

public class StatusCommand extends BaseCommand {

    @Override
    public String execute()  {
        return super.getRecycleController().status();
    }
}