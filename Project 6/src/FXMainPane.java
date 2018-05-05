import java.io.File;

import java.io.FileNotFoundException;

import java.util.Scanner;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;

import javafx.event.Event;

import javafx.event.EventHandler;

import javafx.geometry.Pos;

import javafx.scene.control.Button;

import javafx.scene.control.RadioButton;

import javafx.scene.control.ToggleGroup;

import javafx.scene.control.Label;

import javafx.scene.control.TextField;

import javafx.scene.image.Image;

import javafx.scene.image.ImageView;

import javafx.scene.layout.BorderPane;

import javafx.scene.layout.FlowPane;

import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;

import javafx.stage.FileChooser;

import javafx.geometry.Insets;

	/**
	 * GUI for the Weekly Pay application. Based on a Swing version Modified by
	 * @author Josue Ponce
	 * @version 1.0
	 * 
	 */
public class FXMainPane extends BorderPane {

    private static final long serialVersionUID = 1L;

    private HBox positionButtonGroupPanel, headerPanel, employeeInfoPanel, addEmployeeButtonPanel;

    private VBox addEmployeePanel, employeeLabelPanel, employeeTextPanel;

    private FlowPane employeeMgmtButtonPanel;

    private TextField firstNameField;

    private TextField lastNameField, idField, firstField, secondField;

    private Label headerLabel, idLabel, firstLabel, secondLabel;

    private Label firstNameLabel, lastNameLabel, blankLabel1, blankLabel2;

    private RadioButton manufacturingButton, designButton, salesButton, managerButton;

    private Button addEmployeeButton, removeEmployeeButton, printPayButton, readFileButton, Exit, clearButton,

    printCompanyButton;

    private Company company;

    private ImageView icon;

    public FXMainPane() {

        this.setMaxSize(400, 550); // setPreferredSize(new Dimension(400,550));

        company = new Company("Wacky Widgets");

        firstNameLabel = new Label("First Name:");

        idLabel = new Label("Employee ID:");

        firstLabel = new Label("Weekly Sales:");

        secondLabel = new Label("");

        secondLabel.setVisible(false);

        lastNameLabel = new Label("Last Name:");

        icon = new ImageView("file:src/company.png");

        headerLabel = new Label("Wacky Widgets");

        headerLabel.setStyle("-fx-font-size: 20");

        headerLabel.setPadding(new Insets(0, 0, 20, 0));

        blankLabel1 = new Label(" ");

        blankLabel2 = new Label(" ");

        firstNameField = new TextField();

        lastNameField = new TextField();

        idField = new TextField();

        firstField = new TextField();

        secondField = new TextField();

        secondField.setVisible(false);

        // radio buttons

        salesButton = new RadioButton("Sales");

        salesButton.setOnAction(new RadioButtonHandler());

        manufacturingButton = new RadioButton("Manufacturing");

        manufacturingButton.setOnAction(new RadioButtonHandler());

        designButton = new RadioButton("Design");

        designButton.setOnAction(new RadioButtonHandler());

        managerButton = new RadioButton("Manager");

        managerButton.setOnAction(new RadioButtonHandler());

        ToggleGroup positionButtonGroup = new ToggleGroup();

        designButton.setToggleGroup(positionButtonGroup);

        salesButton.setToggleGroup(positionButtonGroup);

        manufacturingButton.setToggleGroup(positionButtonGroup);

        managerButton.setToggleGroup(positionButtonGroup);

        // add-employee buttons

        addEmployeeButton = new Button("Add Employee");

        // remove employee button

        removeEmployeeButton = new Button("Remove Employee");

        clearButton = new Button("Clear");

        addEmployeeButton.setOnAction(new ButtonHandler());

        removeEmployeeButton.setOnAction(new ButtonHandler());

        clearButton.setOnAction(new ButtonHandler());

        // employee mgmt buttons

        printPayButton = new Button("Print Weekly Pay Report");

        readFileButton = new Button("Read File");

        printCompanyButton = new Button("Print Company Employees");

        Exit = new Button("Exit");

        printPayButton.setOnAction(new ButtonHandler());

        readFileButton.setOnAction(new ButtonHandler());

        Exit.setOnAction(new ButtonHandler());

        printCompanyButton.setOnAction(new ButtonHandler());

        // company title panel

        headerPanel = new HBox();

        headerPanel.getChildren().addAll(icon, headerLabel);

        headerPanel.setAlignment(Pos.CENTER);

        Insets insets = new Insets(40, 10, 20, 10);

        HBox.setMargin(headerLabel, insets);

        headerPanel.setPrefHeight(10);

        setTop(headerPanel);

        BorderPane.setAlignment(headerPanel, Pos.CENTER);

        // radio button panel

        positionButtonGroupPanel = new HBox();

        positionButtonGroupPanel.getChildren().addAll(managerButton, designButton, manufacturingButton, salesButton);

        positionButtonGroupPanel.setAlignment(Pos.CENTER);

        insets = new Insets(10, 10, 20, 10);

        HBox.setMargin(managerButton, insets);

        HBox.setMargin(designButton, insets);

        HBox.setMargin(manufacturingButton, insets);

        HBox.setMargin(salesButton, insets);

        // employee info labels

        employeeLabelPanel = new VBox();

        employeeLabelPanel.getChildren().addAll(idLabel, firstNameLabel, lastNameLabel, firstLabel, secondLabel);

        employeeLabelPanel.setAlignment(Pos.CENTER);

        insets = new Insets(8, 10, 10, 10);

        VBox.setMargin(idLabel, insets);

        VBox.setMargin(firstNameLabel, insets);

        VBox.setMargin(lastNameLabel, insets);

        VBox.setMargin(firstLabel, insets);

        VBox.setMargin(secondLabel, insets);

        // employee info text panels

        employeeTextPanel = new VBox();

        employeeTextPanel.getChildren().addAll(idField, firstNameField, lastNameField, firstField, secondField);

        employeeTextPanel.setAlignment(Pos.CENTER);

        insets = new Insets(5, 10, 5, 10);

        VBox.setMargin(idField, insets);

        VBox.setMargin(firstNameField, insets);

        VBox.setMargin(lastNameField, insets);

        VBox.setMargin(firstField, insets);

        VBox.setMargin(secondField, insets);

        // employee info panel

        employeeInfoPanel = new HBox();

        employeeInfoPanel.getChildren().addAll(employeeLabelPanel, employeeTextPanel);

        employeeInfoPanel.setAlignment(Pos.CENTER);

        // add employee buttons

        addEmployeeButtonPanel = new HBox();

        addEmployeeButtonPanel.getChildren().addAll(addEmployeeButton, removeEmployeeButton, clearButton);

        addEmployeeButtonPanel.setAlignment(Pos.CENTER);

        insets = new Insets(10, 10, 10, 10);

        HBox.setMargin(addEmployeeButton, insets);

        HBox.setMargin(clearButton, insets);

        // employ info

        addEmployeePanel = new VBox();

        addEmployeePanel.getChildren().addAll(positionButtonGroupPanel, employeeInfoPanel, addEmployeeButtonPanel);

        addEmployeePanel.setAlignment(Pos.TOP_CENTER);

        addEmployeePanel.setStyle("-fx-border-color: black");

        setCenter(addEmployeePanel);

        employeeMgmtButtonPanel = new FlowPane();

        employeeMgmtButtonPanel.getChildren().addAll(readFileButton, printCompanyButton, printPayButton, Exit);

        employeeMgmtButtonPanel.setAlignment(Pos.CENTER);

        insets = new Insets(5, 5, 5, 5);

        FlowPane.setMargin(readFileButton, insets);

        FlowPane.setMargin(printCompanyButton, insets);

        FlowPane.setMargin(printPayButton, insets);

        FlowPane.setMargin(Exit, insets);

        setBottom(employeeMgmtButtonPanel);

        BorderPane.setMargin(employeeMgmtButtonPanel, insets);

        setRight(blankLabel1);

        setLeft(blankLabel2);

    }

    public void readFile() throws FileNotFoundException {

        

        FileChooser chooser = new FileChooser();

        Scanner input;

        String[] fields;

        String fname, lname, type, line;

        double salary, wage, payRate, grossSales, piecePrice;

        int empNum, hours, numPieces;

        int paycode;

        File selectedFile = chooser.showOpenDialog(null);

        if (selectedFile != null)

        {

            input = new Scanner(selectedFile);

            while (input.hasNextLine())

            {

                line = input.nextLine();

                fields = line.split(":");

                fname = fields[0];

                lname = fields[1];

                type = fields[2];

                switch (type)

                {

                    case "Manager":

                        salary = Double.parseDouble(fields[3]);

                        empNum = Integer.parseInt(fields[4]);

                        company.addEmployee(fname, lname, "Manager", salary, 0, empNum);

                        break;

                    case "Design":

                        payRate = Double.parseDouble(fields[3]);

                        hours = Integer.parseInt(fields[4]);

                        empNum = Integer.parseInt(fields[5]);

                        company.addEmployee(fname, lname, "Design", payRate, hours, empNum);

                        break;

                    case "Sales":

                        grossSales = Double.parseDouble(fields[3]);

                        empNum = Integer.parseInt(fields[4]);

                        company.addEmployee(fname, lname, "Sales", grossSales, 0, empNum);

                        break;

                    case "Manufacturing":

                        piecePrice = Double.parseDouble(fields[3]);

                        numPieces = Integer.parseInt(fields[4]);

                        empNum = Integer.parseInt(fields[5]);

                        company.addEmployee(fname, lname, "Manufacturing", piecePrice, numPieces, empNum);


                        break;
                    

                }

            }

        }

    }

    private class RadioButtonHandler implements EventHandler {

        public void handle(Event event) {

            // public void actionPerformed(ActionEvent event) {

            if (event.getSource() == designButton)

            {

                firstLabel.setText("Payrate:");

                secondLabel.setText("Hours:");

                secondLabel.setVisible(true);

                secondField.setVisible(true);

            } else if (event.getSource() == salesButton)

            {

                firstLabel.setText("Weekly Sales:");

                secondLabel.setVisible(false);

                secondField.setVisible(false);

            } else if (event.getSource() == managerButton)

            {

                firstLabel.setText("Salary:");

                secondLabel.setVisible(false);

                secondField.setVisible(false);

            } else if (event.getSource() == manufacturingButton)

            {

                firstLabel.setText("Piece rate:");

                secondLabel.setText("# pieces:");

                secondLabel.setVisible(true);

                secondField.setVisible(true);

            }

        }

    }

    private class ButtonHandler implements EventHandler {

        @Override

        public void handle(Event event) {

            Object selectedButton = event.getSource();

            if (selectedButton == addEmployeeButton) {

                String position = "";

                int second = 0, id = 0;

                double first = 0;

                String firstName = firstNameField.getText();

                String lastName = lastNameField.getText();

                id = Integer.parseInt(idField.getText());

                if (salesButton.isSelected())

                {

                    position = "Sales";

                    first = Double.parseDouble(firstField.getText());

                    second = -1;

                } else if (designButton.isSelected())

                {

                    position = "Design";

                    first = Double.parseDouble(firstField.getText());

                    second = Integer.parseInt(secondField.getText());

                } else if (manufacturingButton.isSelected())

                {

                    position = "Manufacturing";

                    first = Double.parseDouble(firstField.getText());

                    second = Integer.parseInt(secondField.getText());

                } else if (managerButton.isSelected())

                {

                    position = "Manager";

                    first = Double.parseDouble(firstField.getText());

                    second = -1;

                }

                String result = company.addEmployee(firstName, lastName, position, first, second, id);

                if (result != null)

                    JOptionPane.showMessageDialog(null, "Employee not added", "Add Employee",

                        JOptionPane.PLAIN_MESSAGE);

                else {

                    JOptionPane.showMessageDialog(null, "Employee added", "Add Employee", JOptionPane.PLAIN_MESSAGE);

                }

            }

            // Remove Employees button
            else if (selectedButton == removeEmployeeButton) {

                // Get first and last name

                String firstName = firstNameField.getText();

                String lastName = lastNameField.getText();

                // Call function

                boolean result = company.removeEmployee(firstName, lastName);

                // SHow message a/c to result

                if (!result)

                    JOptionPane.showMessageDialog(null, "Employee not removed", "Remove Employee",

                        JOptionPane.PLAIN_MESSAGE);

                else

                    JOptionPane.showMessageDialog(null, "Employee " + firstName + " " + lastName + " removed",

                        "Remove employee", JOptionPane.PLAIN_MESSAGE);

            } else if (selectedButton == printPayButton)

            {

                JOptionPane.showMessageDialog(null, company.generateWeeklyReport(), "Weekly Pay Report",

                    JOptionPane.PLAIN_MESSAGE);

            } else if (selectedButton == clearButton)

            {

                idField.setText("");

                firstNameField.setText("");

                lastNameField.setText("");

            } else if (selectedButton == readFileButton)

            {

                try {

                    readFile();

                } catch (FileNotFoundException e) {

                    e.printStackTrace();

                }

            } else if (selectedButton == printCompanyButton)

            {

                JOptionPane.showMessageDialog(null, company.printCompany(), "Employees", JOptionPane.PLAIN_MESSAGE);

            } else if (selectedButton == Exit)

            {

                System.exit(0);

            }

        }

    }
}

