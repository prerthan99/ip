package prerthan.duke;

import javafx.application.Platform;
import prerthan.duke.exception.DukeEmptyDetailException;
import prerthan.duke.exception.DukeInvalidArgumentException;
import prerthan.duke.command.Command;
import prerthan.duke.exception.DukeInvalidCommandException;
import prerthan.duke.exception.DukeInvalidDateTimeException;
import prerthan.duke.io.Input;
import prerthan.duke.io.Output;
import prerthan.duke.io.Storage;
import prerthan.duke.task.TaskList;

import java.util.Optional;

/**
 *
 */
public class Duke {
    public static TaskList tasks;
    public static Input input;
    public static Output output;
    public static Storage fileRW;

    public Duke(String... filePath) {
        
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
        // Initialises file and UI I/O
        fileRW = new Storage("data", "duke.txt");
        input = new Input();
        output = new Output();

        // Greets the user.
        output.sayHello();

        // Creates the task list
        tasks = fileRW.loadFromFile();

        if (programLoop()) {
            exit();
        }
    }

    public void getResponse(String input) {
        
    }
}
