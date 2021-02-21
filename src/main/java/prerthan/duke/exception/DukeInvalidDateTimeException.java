/**
 * @README
all the code up to this point is based off https://github.com/sharadhr
the work thus far is reused code with modifications made to fix bugs, optimise and improve on it.
note, this is true for ALL the code in here and previous tags up to this point
 */
package prerthan.duke.exception;

/**
 * DukeInvalidDateException
 */
public class DukeInvalidDateTimeException extends DukeException {
    private static final long serialVersionUID = 1967070878565904626L;

    public DukeInvalidDateTimeException(String thrownBy, String dateString) {
        super("Invalid date format: " + dateString, thrownBy);
    }

    @Override public String toString() {
        return String.format("%s%nThrown by: %s", this.getMessage(), this.thrownBy);
    }
}