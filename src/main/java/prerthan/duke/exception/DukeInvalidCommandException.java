/**
 * @README
all the code up to this point is based off https://github.com/sharadhr
the work thus far is reused code with modifications made to fix bugs, optimise and improve on it.
note, this is true for ALL the code in here and previous tags up to this point
 */
package prerthan.duke.exception;

/**
 * Thrown when user input is incorrect for a given correct command, or the
 * command does not exist (i.e. the user command resolves to
 * {@link CommandName#INVALID}.)
 */
public class DukeInvalidCommandException extends DukeException {
    private static final long serialVersionUID = 5862830938541195307L;

    public DukeInvalidCommandException(String command, String thrownBy) {
        super("Invalid command: " + command, thrownBy);
    }

    @Override public String toString() {
        return String.format("%s%nThrown by: %s", this.getMessage(), this.thrownBy);
    }
}