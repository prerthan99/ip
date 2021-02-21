/**
 * @README
all the code up to this point is based off https://github.com/sharadhr
the work thus far is reused code with modifications made to fix bugs, optimise and improve on it.
note, this is true for ALL the code in here and previous tags up to this point
 */
package prerthan.duke.exception;

/**
 * An exception thrown to denote that an expected, but invalid program state has
 * been reached. These exceptions are straightforward, and should be caught and
 * handled.
 */
public class DukeException extends Exception {
    private static final long serialVersionUID = 7354097854189773198L;
    protected String thrownBy;

    public DukeException(String message, String thrownBy) {
        super(message);
        this.thrownBy = thrownBy;
    }

    @Override public String toString() {
        return String.format("Message: %s%nStack trace: %s", this.getMessage(), getStackTrace());
    }
}