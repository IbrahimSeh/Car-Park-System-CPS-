package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;


public class SettingTheRateForPaymentController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField Casual_TF;

	@FXML
	private TextField Fullmon_TF;

	@FXML
	private TextField onetime_TF;

	@FXML
	private Button submit_btn;


	@FXML
	void submit_Click(ActionEvent event) {
		if(Casual_TF.getText().isEmpty() ||
				Fullmon_TF.getText().isEmpty() ||
				onetime_TF.getText().isEmpty()) {
    		MyAlert alert = new MyAlert("Setting The Rate For Payment Error", 
    				"Look, an empty fields!", "Ooops, you must fill all the fields!", AlertType.ERROR);
    		alert.showAndWait();
		}
		else {
    		Stage stage = (Stage)submit_btn.getScene().getWindow();
        	String userID = stage.getUserData().toString();
        	String parkingName = new Employee().getParkingNameOfEmployee(userID);
        	new Employee().sendChangeRangesRequest(userID,parkingName,Casual_TF.getText(), onetime_TF.getText(),
					Fullmon_TF.getText());
			/*new Employee().SettingTheRatesForPayment(parkingName,Casual_TF.getText(), onetime_TF.getText(),
					Fullmon_TF.getText());*/
		}
	}

	@FXML
	void initialize() {
		assert Casual_TF != null : "fx:id=\"Casual_TF\" was not injected: check your FXML file 'SettingTheRateForPayment.fxml'.";
		assert Fullmon_TF != null : "fx:id=\"Fullmon_TF\" was not injected: check your FXML file 'SettingTheRateForPayment.fxml'.";
		assert onetime_TF != null : "fx:id=\"onetime_TF\" was not injected: check your FXML file 'SettingTheRateForPayment.fxml'.";
		assert submit_btn != null : "fx:id=\"submit_btn\" was not injected: check your FXML file 'SettingTheRateForPayment.fxml'.";
	}
}
