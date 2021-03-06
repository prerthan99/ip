package prerthan.duke.command;

import prerthan.duke.Duke;
import prerthan.duke.exception.DukeInvalidArgumentException;
import prerthan.duke.io.Storage;
import prerthan.duke.task.TaskList;
import prerthan.duke.io.Output;

/**
 * ByeCommand
 */
public class ByeCommand extends Command {
    private final CommandName commandName = CommandName.BYE;

    public ByeCommand(String[] argumentTokens) throws DukeInvalidArgumentException {
        if (argumentTokens.length != 0) {
            throw new DukeInvalidArgumentException("Bye command should have no arguments.",
                                                   argumentTokens, this.commandName,
                                                   this.getClass().getSimpleName());
        }
    }

    @Override public void execute(TaskList tasks, Storage storage, Output output) {
        Duke.output.sayGoodBye();
    }

    @Override public boolean willTerminate() {
        return true;
    }
}