/**
 * @README
all the code up to this point is based off https://github.com/sharadhr
the work thus far is reused code with modifications made to fix bugs, optimise and improve on it.
note, this is true for ALL the code in here and previous tags up to this point
 */
package prerthan.duke.exception;

import prerthan.duke.task.Task;

/**
 * An exception thrown when the {@code detail} {@link String} passed to a
 * {@link Task} constructor is empty.
 */
public class DukeEmptyDetailException extends DukeException {
    private static final long serialVersionUID = 1127957475772724808L;

    public DukeEmptyDetailException(String thrownBy) {
        super("Task detail cannot be empty.", thrownBy);
    }

    @Override public String toString() {
        return String.format("%s%nThrown by: %s", this.getMessage(), this.thrownBy);
    }
}