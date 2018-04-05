/**
 
 * MgmCompanyGui, Class representing the GUI for company information

 * @author Josue Ponce
 
 * @version 1.0
 
 */

import java.text.NumberFormat;
import javax.swing.JOptionPane;

//import MvGuiFx.ButtonEventHandler;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TitledPane;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
 
public class MgmCompanyGui extends Application {

	private TextField mgmNametxt, mgmIdtxt, mgmFeetxt, propNametxt,
									propCitytxt, propRenttxt, propOwnertxt;
	private Label mgmNamelbl, mgmIdlbl, mgmFeelbl, propNamelbl, propCitylbl,
												propRentlbl, propOwnerlbl;
	private NumberFormat numFormat = NumberFormat.getNumberInstance();
	private Button newMgmBtn, addPropertyBtn, maxRentBtn, totalRentBtn, propListBtn, exitBtn;
	private Alert alert = new Alert(AlertType.INFORMATION);
	 

	private ManagementCompany mgmCompany;

	/**
	 * 
	 * @return true if any of the field related to the property is empty, false otherwise
	 */
	private boolean propertyFieldsEmpty()
	{
		if  ( propNametxt.getText().equals("") || propCitytxt.getText().equals("") ||  
				propRenttxt.getText().equals("") || propOwnertxt.getText().equals("") )
			return true;
		return false;
		
	}
	/**
	 * 
	 * @return true if any of the field related to the management company is empty, false otherwise
	 */
	private boolean mgmFieldsEmpty()
	{
		if  ( mgmNametxt.getText().equals("") || mgmIdtxt.getText().equals("") ||  mgmFeetxt.getText().equals("") )
			return true;
		return false;
		
	}
	/**
	 * Creates a ManagementCompany object using information from the GUI and 
	 * sets the text fields to 
	 */
	private void createNewMgm()
	{
		if  (!mgmFieldsEmpty())
		{
			// check if fee is valid (0-100)
			if (Double.parseDouble(mgmFeetxt.getText()) < 0
					|| Double.parseDouble(mgmFeetxt.getText()) > 100)
				 
			{
			 
				alert.setContentText("Fee is not valid, Correct value is between 0-100");
				alert.showAndWait();
			}
			else {
				// Create management company object
				mgmCompany = new ManagementCompany(mgmNametxt.getText(),
						mgmIdtxt.getText(), Double.parseDouble(mgmFeetxt
								.getText()));
				//Enable Property buttons
				newMgmBtn.setDisable(true);
				addPropertyBtn.setDisable(false);
				maxRentBtn.setDisable(false);
				totalRentBtn.setDisable(false);	
				propListBtn.setDisable(false);
				//set Management text fields to read only
				mgmNametxt.setEditable(false);
				mgmIdtxt.setEditable(false);	 
				mgmFeetxt.setEditable(false);
				newMgmBtn.setDisable(true);
				//set property text fields to editable
				propNametxt.setEditable(true);
				propCitytxt.setEditable(true);
				propRenttxt.setEditable(true);
				propOwnertxt.setEditable(true);
			}
		}
	}
	 
	/**
	 * Create a property object and calls mgmCompany method to add it to the list of properties.
	 * If the property can not be added an error message will be displayed.
	 */
	private void addProp()
	{
		if (!propertyFieldsEmpty())
		{
			Property p = new Property(propNametxt.getText(),
					propCitytxt.getText(), Double.parseDouble(propRenttxt
							.getText()), propOwnertxt.getText());
			if (mgmCompany.addProperty(p) == -1)
				 
			{
				alert.setContentText( "This Property can not be managed by this company.\n"
						+ "  The maximum capacity to manage for this company is :  "
						+ mgmCompany.getMAX_PROPERTY());
				alert.showAndWait();
				
			}
		}
	}
	private void setBlank()
	{
		propNametxt.setText("");
		propCitytxt.setText("");
		propRenttxt.setText("");
		propOwnertxt.setText("");
		
	}
	// Handler class.
	private class ButtonEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {

			if (e.getSource() == newMgmBtn) {
				createNewMgm();

			} else if (e.getSource() == addPropertyBtn) {

				addProp();
				setBlank();

			} else if (e.getSource() == maxRentBtn) {
				
				/*JOptionPane.showMessageDialog(null,
						mgmCompany.displayPropertyAtIndex(mgmCompany.maxPropertyRentIndex()));*/
				
				alert.setContentText( mgmCompany.displayPropertyAtIndex(mgmCompany.maxPropertyRentIndex()));
				alert.showAndWait();
			}
		    else if (e.getSource() == totalRentBtn) {
			
		    	//JOptionPane.showMessageDialog(null,"Total Rent of the properties: "+mgmCompany.totalRent());
		    	alert.setContentText(  "Total Rent of the properties: "+ mgmCompany.totalRent());
				alert.showAndWait();
		    	
	     	}

			else if (e.getSource() == propListBtn) {
				//JOptionPane.showMessageDialog(null,mgmCompany.toString());
				alert.setContentText(  mgmCompany.toString());
				alert.showAndWait();
				

			} else if (e.getSource() == exitBtn)

				System.exit(0);
		}
	}

	@Override
	public void start(Stage stage) {
		
		alert.setTitle("Management Company");
		alert.setHeaderText(null);
		// Create management company labels
		mgmNamelbl = new Label("Name: ");
		mgmIdlbl = new Label("Tax Id:");
		mgmFeelbl = new Label("Fee %:");

		// create management company text fields
		mgmNametxt = new TextField();
		mgmNametxt.setMaxWidth(100);
		mgmIdtxt = new TextField();
		mgmIdtxt.setMaxWidth(80);
		mgmFeetxt = new TextField();
		mgmFeetxt.setMaxWidth(40);

		// Create property labels
		propNamelbl = new Label("Property Name");
		propCitylbl = new Label("City");
		propRentlbl = new Label("Rent");
		propOwnerlbl = new Label("Owner");

		// create property text fields and set them to read only at the begining
		propNametxt = new TextField();
		propNametxt.setEditable(false);
		propNametxt.setMaxWidth(100);
		propCitytxt = new TextField();
		propCitytxt.setEditable(false);
		propCitytxt.setMaxWidth(80);
		propRenttxt =  new TextField();
	 	propRenttxt.setEditable(false);
		propRenttxt.setMaxWidth(80);
		propOwnertxt = new TextField();
		propOwnertxt.setEditable(false);
		propOwnertxt.setMaxWidth(100);

		// Create buttons
		newMgmBtn = new Button("New Management Company");
		addPropertyBtn = new Button("Add Property");
		maxRentBtn = new Button("Max Rent");
		totalRentBtn = new Button("Total Rent");
		propListBtn = new Button("List of Properties");
		exitBtn = new Button("Exit");

		newMgmBtn.setOnAction(new ButtonEventHandler());
		addPropertyBtn.setOnAction(new ButtonEventHandler());
		maxRentBtn.setOnAction(new ButtonEventHandler());
		propListBtn.setOnAction(new ButtonEventHandler());
		totalRentBtn.setOnAction(new ButtonEventHandler());
		exitBtn.setOnAction(new ButtonEventHandler());

		// Disable some buttons
		addPropertyBtn.setDisable(true);
		maxRentBtn.setDisable(true);
		totalRentBtn.setDisable(true);
		propListBtn.setDisable(true);

		// Main Pane
		VBox mainPane = new VBox();

		// Management company pane
		HBox mgmInfoPane = new HBox(5);

		// Add management company info to the pane
		mgmInfoPane.getChildren().addAll(mgmNamelbl, mgmNametxt, mgmIdlbl,
				mgmIdtxt, mgmFeelbl, mgmFeetxt);

		TitledPane mgmTitlePane = new TitledPane("Management Company",
				mgmInfoPane);
		mgmTitlePane.setCollapsible(false);
		mgmTitlePane.setMaxWidth(450);
		mgmTitlePane.setPadding(new Insets(20, 10, 5, 10));

		// Create property pane
		VBox propPane = new VBox();

		propPane.getChildren().addAll(propNamelbl, propNametxt, propCitylbl,
				propCitytxt, propRentlbl, propRenttxt, propOwnerlbl,
				propOwnertxt);
		TitledPane propertyTitlePane = new TitledPane("Property Information",
				propPane);
		propertyTitlePane.setCollapsible(false);
		propertyTitlePane.setMaxWidth(350);
		propertyTitlePane.setPadding(new Insets(5, 100, 10, 150));

		// Create button pane
		HBox buttonPane1 = new HBox(20);
		buttonPane1.setAlignment(Pos.CENTER);
		buttonPane1.getChildren().addAll(newMgmBtn, addPropertyBtn,maxRentBtn);

		HBox buttonPane2 = new HBox(20);
		buttonPane2.setPadding(new Insets(10, 0, 10, 0));
		buttonPane2.setAlignment(Pos.CENTER);
		buttonPane2.getChildren().addAll(totalRentBtn, propListBtn, exitBtn);
		mainPane.getChildren().addAll(mgmTitlePane, propertyTitlePane,
				buttonPane1, buttonPane2);

		Scene scene = new Scene(mainPane, 450, 400);
		stage.setScene(scene);

		// Set stage title and show the stage.
		stage.setTitle("Rental Management ");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}