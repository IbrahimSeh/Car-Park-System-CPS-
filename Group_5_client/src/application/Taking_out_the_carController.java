/**
 * Sample Skeleton for 'Taking_out_the_car.fxml' Controller Class
 */

package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Taking_out_the_carController {

    @FXML // fx:id="carnumL"
    private Label carnumL; // Value injected by FXMLLoader

    @FXML // fx:id="titleL"
    private Label titleL; // Value injected by FXMLLoader

    @FXML // fx:id="submitBn"
    private Button submitBn; // Value injected by FXMLLoader

    @FXML // fx:id="carnumTf"
    private TextField carnumTf; // Value injected by FXMLLoader

    @FXML // fx:id="cancelBn"
    private Button cancelBn; // Value injected by FXMLLoader

    @FXML
    void Submit_exit_car_click(ActionEvent event) {
    	if(carnumTf.getText().isEmpty()) {
    		MyAlert alert = new MyAlert("Taking Out Car Error", 
    				"Look, an empty field!", "Ooops, you must fill the field!", AlertType.ERROR);
			alert.showAndWait();
    	}
    	else {
    		Client client = new Client();
    		String result = client.takeOutTheCar(carnumTf.getText());
    		MyAlert alert = new MyAlert("Taking Out The Car Result:", 
    				"The result of taking out the car:", result, AlertType.INFORMATION);
			alert.showAndWait();
    	}
    }

    @FXML
    void Cancel_exit_car_click(ActionEvent event) {
    	Stage stage = (Stage)cancelBn.getScene().getWindow();
    	stage.close();
    }
}
