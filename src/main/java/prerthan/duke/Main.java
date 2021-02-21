/**
 * @README
 all the code up to this point is based off https://github.com/sharadhr
 the work thus far is reused code with modifications made to fix bugs, optimise and improve on it.
 note, this is true for ALL the code in here and previous tags up to this point
 */

package prerthan.duke;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import prerthan.duke.ui.MainWindow;

import java.io.IOException;

/**
 * Main
 */
public class Main extends Application {
    private Duke duke = new Duke("data", "tasks.csv");

    @Override public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            fxmlLoader.<MainWindow>getController().setDuke(duke);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}