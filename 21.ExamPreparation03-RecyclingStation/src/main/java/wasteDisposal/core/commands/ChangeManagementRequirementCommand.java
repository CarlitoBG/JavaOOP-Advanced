package wasteDisposal.core.commands;

import wasteDisposal.core.BaseCommand;

public class ChangeManagementRequirementCommand extends BaseCommand{

    @Override
    public String execute(){
        return super.getRecycleController().changeManagementRequirement(
                Double.parseDouble(super.getParams().get(0)),
                Double.parseDouble(super.getParams().get(1)),
                super.getParams().get(2));
    }
}