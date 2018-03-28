/**
 * GUI for hello world application. 
 * @author Josue Ponce
 * @date 3/27/18
 * @version 1.0
 */


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	TextField textField;
	// Extra button for fun
	Button frenchButton;
	
	Button helloButton;
	
	Button howdyButton;
	
	Button chineseButton;
	
	Button clearButton;
	
	Button exitButton;
	
	Label labelVal;
	//  declare two HBoxes
    HBox hb1;
    
    HBox hb2;
	
	//student Task #4:
	//  declare an instance of DataManager
	DataManager data;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		labelVal=new Label("Feedback");
		
		textField = new TextField();
		
		helloButton = new Button("Hello");
		
		howdyButton = new Button("Howdy");
		
		chineseButton = new Button("Chinese");
		
		// For fun button. 
		frenchButton = new Button ("French");
		
		clearButton = new Button("Clear");
		
		exitButton = new Button("Exit");
		//  instantiate the HBoxes
        hb1 = new HBox();
        
        hb2 = new HBox();
        
   
		
		//student Task #4:
		//  instantiate the DataManager instance
		data = new DataManager();
		
		//  set margins and set alignment of the components
        HBox.setMargin(helloButton,new Insets(10));
    	helloButton.setOnAction(new ButtonHandler());
    	
        HBox.setMargin(howdyButton,new Insets(10));
    	howdyButton.setOnAction(new ButtonHandler());
    	
        HBox.setMargin(chineseButton,new Insets(10));
		chineseButton.setOnAction(new ButtonHandler());
		
		HBox.setMargin(frenchButton,new Insets(10));
		frenchButton.setOnAction(new ButtonHandler());
		
        HBox.setMargin(clearButton,new Insets(10));
		clearButton.setOnAction(new ButtonHandler());
		
        HBox.setMargin(exitButton,new Insets(10));
		exitButton.setOnAction(new ButtonHandler());
		
        HBox.setMargin(labelVal,new Insets(10));
        
        hb1.setAlignment(Pos.CENTER);
        
        hb2.setAlignment(Pos.CENTER);
		//student Task #3:
        
		//  add the label and textfield to one of the HBoxes
        hb1.getChildren().addAll(labelVal, textField);
        
		//  add the buttons to the other HBox
        hb2.getChildren().addAll(helloButton, howdyButton, chineseButton, frenchButton, clearButton, exitButton);
        
		//  add the HBoxes to this FXMainPanel (a VBox)
    	getChildren().addAll(hb1, hb2);
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler <ActionEvent> 
	{
		public void handle (ActionEvent event) 
		{ 
			
			Object source = event.getTarget(); 
			
			
			if (source == helloButton)
			{
				String input = data.getHello();
				textField.setText(input);
			}
			else if (source == howdyButton)
			{
				String input = data.getHowdy();
				textField.setText(input);
			}
			else if (source == frenchButton) {
				String input = data.getFrench();
				textField.setText(input);
			}
			else if(source == chineseButton)
            {
               String input = data.getChinese();
               textField.setText(input);
            }
			
             else if(source == clearButton)
            {
               textField.setText("");
            }
             else if(source == exitButton)
            {
               Platform.exit();
                System.exit(0);
            }
	
		}
	
	}
}
	
	