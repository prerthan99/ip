/**
 * @README
all the code up to this point is based off https://github.com/sharadhr
the work thus far is reused code with modifications made to fix bugs, optimise and improve on it.
note, this is true for ALL the code in here and previous tags up to this point
 */
package prerthan.duke.command;

import prerthan.duke.io.Output;
import prerthan.duke.io.Storage;
import prerthan.duke.Duke;
import prerthan.duke.exception.DukeInvalidArgumentException;
import prerthan.duke.task.TaskList;

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