/**
 * Sample Skeleton for 'CheckOrderStatus.fxml' Controller Class
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

public class CheckOrderStatusController {

	@FXML // fx:id="id_TF"
	private TextField id_TF; // Value injected by FXMLLoader

	@FXML // fx:id="cancel_btn"
	private Button cancel_btn; // Value injected by FXMLLoader

	@FXML // fx:id="Idorder_btn"
	private Label Idorder_btn; // Value injected by FXMLLoader

	@FXML // fx:id="submit_btn"
	private Button submit_btn; // Value injected by FXMLLoader

	@FXML
	void cancel_click(ActionEvent event) {
		Stage stage = (Stage)cancel_btn.getScene().getWindow();
		stage.close();
	}

	@FXML
	void submit_click(ActionEvent event) {

		if(id_TF.getText().isEmpty()) {
			MyAlert alert = new MyAlert("Check Order Status Error", 
					"Look, an empty field!","Ooops, you must fill the field!", AlertType.ERROR);
			alert.showAndWait();
		}
		else {
			Client client = new Client();
			String result = client.checkOrderStatus(id_TF.getText());
			MyAlert alert = new MyAlert("Check Order Status Result:", 
					"The result of checking order status:" ,result, AlertType.INFORMATION);
			alert.showAndWait();
		}
	}
}
