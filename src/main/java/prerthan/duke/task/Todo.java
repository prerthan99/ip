/**
 * @README
all the code up to this point is based off https://github.com/sharadhr
the work thus far is reused code with modifications made to fix bugs, optimise and improve on it.
note, this is true for ALL the code in here and previous tags up to this point
 */

package prerthan.duke.task;

import prerthan.duke.exception.DukeEmptyDetailException;

/**
 * A To-Do; effectively the same as the inherited abstract class, {@link Task}.
 */
public class Todo extends Task {

    /**
     * Creates a Todo with some detail.
     *
     * @param detail the Todo detail
     * @throws DukeEmptyDetailException if the detail is blank
     */
    public Todo(String detail) throws DukeEmptyDetailException {
        super(detail);
    }

    public Todo(String detail, boolean isComplete) throws DukeEmptyDetailException {
        super(detail, isComplete);
    }

    @Override public char getTaskTypeIcon() {
        return 'T';
    }

    @Override public String toString() {
        return String.format("[%c]%s", this.getTaskTypeIcon(), super.toString());
    }

    @Override public String encode() {
        return String
            .format("%c,%d,%s", this.getTaskTypeIcon(), this.isComplete ? 1 : 0, this.detail);
    }
}