/**
 * Sample Skeleton for "EmployeeParking.fxml" Controller Class
 * You can copy and paste this code into your favorite IDE
 **/

package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;


public class EmployeeParkingController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="floor_TF"
    private TextField floor_TF; // Value injected by FXMLLoader

    @FXML // fx:id="markPlaceRadio"
    private ToggleGroup markPlaceRadio; // Value injected by FXMLLoader

    @FXML // fx:id="mark_rb"
    private RadioButton mark_rb; // Value injected by FXMLLoader

    @FXML // fx:id="place_TF"
    private TextField place_TF; // Value injected by FXMLLoader

    @FXML // fx:id="row_TF"
    private TextField row_TF; // Value injected by FXMLLoader

    @FXML // fx:id="save_rb"
    private RadioButton save_rb; // Value injected by FXMLLoader

    @FXML // fx:id="setUp_btn"
    private Button setUp_btn; // Value injected by FXMLLoader

    @FXML // fx:id="submit_btn"
    private Button submit_btn; // Value injected by FXMLLoader

    @FXML // fx:id="title"
    private Label title; // Value injected by FXMLLoader


    // Handler for Button[fx:id="setUp_btn"] onAction
    @FXML
   
    void submitMarking_Click(ActionEvent event) {
    	if(!save_rb.isSelected() && !mark_rb.isSelected()) {
    		MyAlert alert = new MyAlert("Employee Parking Error", "No sellected item!",
    				"Youm must choice one of the options.", AlertType.ERROR);
    		alert.showAndWait();
    		
    	}
    	else if(floor_TF.getText().isEmpty() || row_TF.getText().isEmpty() || place_TF.getText().isEmpty()) {
    		MyAlert alert = new MyAlert("Employee Parking Error", "There is an empty field!",
    				"Please fill the field!", AlertType.ERROR);
    		alert.showAndWait();
    	}
    	else {
    		Stage stage = (Stage)setUp_btn.getScene().getWindow();
        	String userID = stage.getUserData().toString();
        	String parkingName = new Employee().getParkingNameOfEmployee(userID);
    		if(mark_rb.isSelected()) {
    			new Employee().MarkProblemInCertainPark(parkingName,floor_TF.getText(),row_TF.getText(), place_TF.getText());
    		}
    			else {
    				
    			new Employee().SaveParkingPlace(parkingName,floor_TF.getText(),row_TF.getText(), place_TF.getText());
    		}
    	}
    }

    // Handler for Button[fx:id="submit_btn"] onAction
    @FXML
    void setUp_click(ActionEvent event) { 
    		Stage stage = (Stage)setUp_btn.getScene().getWindow();
        	String userID = stage.getUserData().toString();
    	MyWindow window = new MyWindow("SetUpNewParking.fxml", "Set Up New Parking Window", 
    			"file:addEmployeeIcon.png", 500, 400);
    	window.setUserData(userID);
    	window.view();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert floor_TF != null : "fx:id=\"floor_TF\" was not injected: check your FXML file 'EmployeeParking.fxml'.";
        assert markPlaceRadio != null : "fx:id=\"markPlaceRadio\" was not injected: check your FXML file 'EmployeeParking.fxml'.";
        assert mark_rb != null : "fx:id=\"mark_rb\" was not injected: check your FXML file 'EmployeeParking.fxml'.";
        assert place_TF != null : "fx:id=\"place_TF\" was not injected: check your FXML file 'EmployeeParking.fxml'.";
        assert row_TF != null : "fx:id=\"row_TF\" was not injected: check your FXML file 'EmployeeParking.fxml'.";
        assert save_rb != null : "fx:id=\"save_rb\" was not injected: check your FXML file 'EmployeeParking.fxml'.";
        assert setUp_btn != null : "fx:id=\"setUp_btn\" was not injected: check your FXML file 'EmployeeParking.fxml'.";
        assert submit_btn != null : "fx:id=\"submit_btn\" was not injected: check your FXML file 'EmployeeParking.fxml'.";
        assert title != null : "fx:id=\"title\" was not injected: check your FXML file 'EmployeeParking.fxml'.";

        // Initialize your logic here: all @FXML variables will have been injected

    }

}




