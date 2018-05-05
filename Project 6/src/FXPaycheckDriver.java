
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
/**
 * Driver for the Weekly Pay GUI in JavaFX
 * @author Josue Ponce
 * @version 1.0
 *
 */
public class FXPaycheckDriver extends Application
{
    public FXPaycheckDriver()  {
    }

   public static void main (String[] args)
   {
      launch(args);
   }

	@Override
	public void start(Stage stage) throws Exception {		
		FXMainPane root = new FXMainPane();
        stage.setScene(new Scene(root, 400, 450));
		// Set stage title and show the stage.
		stage.setTitle("Employee Management");
		stage.show();
	}
}