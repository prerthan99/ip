package prerthan.duke.command;

import prerthan.duke.exception.DukeEmptyDetailException;
import prerthan.duke.exception.DukeInvalidDateTimeException;
import prerthan.duke.io.Storage;
import prerthan.duke.task.Deadline;
import prerthan.duke.task.TaskList;
import prerthan.duke.task.Todo;
import prerthan.duke.io.Output;
import prerthan.duke.task.Event;

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