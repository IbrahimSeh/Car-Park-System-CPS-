package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Insert_the_carController {

    @FXML
    private Label titleL;

    @FXML
    private Label carnumL;

    @FXML
    private TextField carnumTf;

    @FXML
    private Button submitBn;

    @FXML
    private Button cancelBn;

    @FXML
    void Cancel_insert_car_click(ActionEvent event) {
    	Stage stage = (Stage)cancelBn.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void Submit_insert_car_click(ActionEvent event) {
    	if(carnumTf.getText().isEmpty()) {
    		MyAlert alert = new MyAlert("Inserting Car Error", 
    				"Look, an empty field!", "Ooops, you must fill the field!", AlertType.ERROR);
			alert.showAndWait();
    	}
    	else {
    		Client client = new Client();
    		String result = client.insertTheCar(carnumTf.getText());
    		MyAlert alert = new MyAlert("Inserting Car Result:", 
    				"The result of Inserting the car:", result, AlertType.INFORMATION);
			alert.showAndWait();
    	}
    }
}
