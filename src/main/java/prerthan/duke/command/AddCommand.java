/**
 * @README
all the code up to this point is based off https://github.com/sharadhr
the work thus far is reused code with modifications made to fix bugs, optimise and improve on it.
note, this is true for ALL the code in here and previous tags up to this point
 */
package prerthan.duke.command;

import prerthan.duke.exception.DukeEmptyDetailException;
import prerthan.duke.exception.DukeInvalidDateTimeException;
import prerthan.duke.io.Output;
import prerthan.duke.io.Storage;
import prerthan.duke.task.Deadline;
import prerthan.duke.task.Event;
import prerthan.duke.task.Todo;
import prerthan.duke.task.TaskList;

/**
 * AddCommand
 */
public class AddCommand extends Command {

    public AddCommand(String detail, CommandName commandName) {
        super(detail);
        this.commandName = commandName;
    }

    public AddCommand(String detail, String timeString, CommandName commandName) {
        super(detail, timeString);
        this.commandName = commandName;
    }

    public AddCommand(String detail, String startString, String endString,
                      CommandName commandName) {
        super(detail, startString, endString);
        this.commandName = commandName;
    }

    @Override public void execute(TaskList tasks, Storage storage, Output output)
        throws DukeEmptyDetailException, DukeInvalidDateTimeException {
        switch (this.commandName) {
        case TODO:
            tasks.addTask(new Todo(this.argumentTokens[0]));
            break;
        case EVENT:
            tasks.addTask(
                new Event(this.argumentTokens[0], this.argumentTokens[1], this.argumentTokens[2]));
            break;
        case DEADLINE:
            tasks.addTask(new Deadline(this.argumentTokens[0], this.argumentTokens[1]));
            break;
        default:
            break;
        }
    }
}