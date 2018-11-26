package p02_command.executor;

import p02_command.interfaces.Command;
import p02_command.interfaces.Executor;

public class CommandExecutor implements Executor{

    @Override
    public void executeCommand(Command command) {
        command.execute();
    }
}