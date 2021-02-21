/**
 * @README
all the code up to this point is based off https://github.com/sharadhr
the work thus far is reused code with modifications made to fix bugs, optimise and improve on it.
note, this is true for ALL the code in here and previous tags up to this point
 */
package prerthan.duke.command;

import prerthan.duke.exception.DukeInvalidArgumentException;
import prerthan.duke.io.Output;
import prerthan.duke.io.Storage;
import prerthan.duke.task.Task;
import prerthan.duke.task.TaskList;

/**
 * DoneCommand
 */
public class DoneCommand extends Command {
    private int position;

    DoneCommand(String[] commandTokens, int position) throws DukeInvalidArgumentException {

        // if (this.argumentTokens.length != 1 || !this.argumentTokens[0].matches("\\d+")) {
        //     throw new DukeInvalidArgumentException(argument, this.commandName, this.getClass()
        //     .getSimpleName());
        // }
        // this.commandName = CommandName.DONE;
        // this.position = position;
    }

    /**
     * @param argumentTokens
     * @throws DukeInvalidArgumentException
     */
    public DoneCommand(String[] argumentTokens) throws DukeInvalidArgumentException {
        this(argumentTokens, Integer.parseInt(argumentTokens[1]));
    }

    @Override public void execute(TaskList tasks, Storage storage, Output output) {
        if (!(this.position >= 1) && this.position <= tasks.numberOfTasks()) {
            Task toComplete = tasks.getTaskAtPosition(position);
            if (toComplete.markComplete()) {
                output.sayTaskMarkedComplete(toComplete);
            }
        }
    }
}