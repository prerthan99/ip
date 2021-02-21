package prerthan.duke;

import javafx.application.Platform;
import prerthan.duke.command.Command;
import prerthan.duke.exception.DukeEmptyDetailException;
import prerthan.duke.exception.DukeInvalidArgumentException;
import prerthan.duke.exception.DukeInvalidCommandException;
import prerthan.duke.exception.DukeInvalidDateTimeException;
import prerthan.duke.io.Input;
import prerthan.duke.io.Output;
import prerthan.duke.io.Storage;
import prerthan.duke.task.TaskList;

/**
 * @README
all the code up to this point is based off https://github.com/sharadhr
the work thus far is reused code with modifications made to fix bugs, optimise and improve on it.
note, this is true for ALL the code in here and previous tags up to this point
 */

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Optional;

/**
 *
 */
public class Duke {
    public static TaskList tasks;
    public static Input input;
    public static Output output;
    public static Storage fileRW;
    public static PrintStream outputPS;
    public static ByteArrayInputStream baIS;
    public static ByteArrayOutputStream baOS;

    public Duke(String... filePath) {
        fileRW = new Storage(filePath);
        assert fileRW != null || input != null || output != null;

        baOS = new ByteArrayOutputStream();
        outputPS = new PrintStream(baOS);
        System.setOut(outputPS);
        output = new Output(outputPS);

        input = new Input();

        tasks = fileRW.loadFromFile();
    }

    /**
     * Runs the main program loop.
     *
     * @return {@code false} when the user says 'bye'; otherwise, never returns.
     */
    public static boolean programLoop() {
        boolean isExit = false;
        while (!isExit) {
            try {
                Optional<Command> possibleCommand = input.nextLine().getCommand();
                if (!possibleCommand.isPresent()) {
                    output.say("Input cannot be empty; please enter a command.");
                    continue;
                }
                possibleCommand.get().execute(tasks, fileRW, output);
                isExit = possibleCommand.get().willTerminate();
            }
            catch (DukeInvalidArgumentException | DukeInvalidCommandException | DukeEmptyDetailException | DukeInvalidDateTimeException e) {
                output.sayError(e);
            }
        }
        return isExit;
    }

    /**
     * Cleans up objects and quits the program by calling {@link System#exit(int)}.
     */
    public static void exit() {
        output.sayGoodBye();

        input.close();
        output.close();
        Platform.exit();
        System.exit(0);
    }

    public static void main(String[] args) {
        //new Duke("data", "duke.csv");

        output.sayHello();

        // Creates the task list

        if (programLoop()) {
            exit();
        }
    }

    public String getResponse() {
        boolean isExit = false;
        try {
            Optional<Command> possibleCommand = input.getCommand();
            if (!possibleCommand.isPresent()) {
                output.say("Input cannot be empty; please enter a command.");
            }
            possibleCommand.get().execute(tasks, fileRW, output);
            isExit = possibleCommand.get().willTerminate();
        }
        catch (DukeInvalidArgumentException | DukeInvalidCommandException | DukeEmptyDetailException | DukeInvalidDateTimeException e) {
            output.sayError(e);
        }

        if (isExit) {
            exit();
        }

        String returnable = baOS.toString();
        baOS.reset();

        return returnable;
    }

    public void redirect(String inputString) {
        input.setFromString(inputString);
    }
}
