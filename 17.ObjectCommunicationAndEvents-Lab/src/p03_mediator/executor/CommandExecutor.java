package p03_mediator.executor;

import p03_mediator.interfaces.Command;
import p03_mediator.interfaces.Executor;

public class CommandExecutor implements Executor {

    @Override
    public void executeCommand(Command command) {
        command.execute();
    }
}