/**
 * Sample Skeleton for 'CancelOrder.fxml' Controller Class
 */

package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CancelOrderController {

    @FXML // fx:id="idOrder_TF"
    private TextField idOrder_TF; // Value injected by FXMLLoader

    @FXML // fx:id="Submit_btn"
    private Button Submit_btn; // Value injected by FXMLLoader

    @FXML // fx:id="Cancel_btn"
    private Button Cancel_btn; // Value injected by FXMLLoader

    @FXML
    void cancel_click(ActionEvent event) {
    	Stage stage = (Stage)Cancel_btn.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void submit_click(ActionEvent event) {
    	if(idOrder_TF.getText().isEmpty()) {    		
    		MyAlert alert = new MyAlert("Cancel Order Error", 
    				"Look, an empty field!", "Ooops, you must fill the field!", AlertType.ERROR);
			alert.showAndWait();
    	}
    	else{
    		Client client = new Client();
    		String result = client.cancel_order(idOrder_TF.getText());
    		MyAlert alert = new MyAlert("Cancel Order Result", 
    				"The result of cancelling an order:",result, AlertType.INFORMATION);
			alert.showAndWait();
    	}
    }

}
