/**
 * @README
all the code up to this point is based off https://github.com/sharadhr
the work thus far is reused code with modifications made to fix bugs, optimise and improve on it.
note, this is true for ALL the code in here and previous tags up to this point
 */

package prerthan.duke;

import javafx.application.Application;

/**
 * A launcher class to workaround classpath issues.
 */
public class DukeLauncher {
    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }
}