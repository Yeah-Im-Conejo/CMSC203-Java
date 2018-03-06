
import java.io.IOException;
import javafx.application.Application;
//import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
* Driver class that launches the Crypto manager application.
* @author Josue Ponce
* version 1.0
*/

public class FXDriver extends Application {
	   
	/**
	 * The main method for the GUI JavaFX version
	 * @param args not used
	 */
	public static void main(String[] args) {
		launch(args);   
	}
	
	/**
	 * Stage stage sets up the main stage and scene for the application's GUI.
	 * Also, calls FXMainPane
	 * @param Stage stage
	 * @throws IOException 
	 */
	@Override
	public void start(Stage stage) throws Exception {
		//call the main scene which is a BorderPane
		FXMainPane root = new FXMainPane();
        stage.setScene(new Scene(root, 600, 350));
		// Set stage title and show the stage.
		stage.setTitle("Cybersecurity Encryption and Decryption");
		stage.show();

	}
}