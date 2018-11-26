package p04_observer.executor;

import p04_observer.interfaces.Command;
import p04_observer.interfaces.Executor;

public class CommandExecutor implements Executor {

    @Override
    public void executeCommand(Command command) {
        command.execute();
    }
}