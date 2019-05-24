package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class ParkingManagerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addnewemp_btn;

    @FXML
    private Button setting_btn;


    @FXML
    void addnewemp_Click(ActionEvent event) {
		MyWindow window = new MyWindow("Add_new_employee.fxml", "Add New Employee Window", 
				"file:addEmployeeIcon.png", 600, 320);
		Stage stage = (Stage)addnewemp_btn.getScene().getWindow();
    	String userID = stage.getUserData().toString();
    	window.setUserData(userID);
		window.view();
    }

    @FXML
    void setting_Click(ActionEvent event) {
    	MyWindow window = new MyWindow("SettingTheRateForPayment.fxml", "Setting The Rate For Payment Window", 
				"file:settingtherateforpaymenticon.png", 500, 280);
		Stage stage = (Stage)addnewemp_btn.getScene().getWindow();
    	String userID = stage.getUserData().toString();
    	window.setUserData(userID);
		window.view();
    }

    @FXML
    void initialize() {
        assert addnewemp_btn != null : "fx:id=\"addnewemp_btn\" was not injected: check your FXML file 'ParkingManager.fxml'.";
        assert setting_btn != null : "fx:id=\"setting_btn\" was not injected: check your FXML file 'ParkingManager.fxml'.";
    }

}
