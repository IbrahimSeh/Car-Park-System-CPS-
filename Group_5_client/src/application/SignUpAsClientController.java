/**
 * Sample Skeleton for 'SignUpAsClient.fxml' Controller Class
 */

package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class SignUpAsClientController {

    @FXML // fx:id="userId_TF"
    private TextField userId_TF; // Value injected by FXMLLoader

    @FXML // fx:id="Submit_btn"
    private Button Submit_btn; // Value injected by FXMLLoader

    @FXML // fx:id="confirmpass_TF"
    private TextField confirmpass_TF; // Value injected by FXMLLoader

    @FXML // fx:id="password_TF"
    private TextField password_TF; // Value injected by FXMLLoader

    @FXML
    void signUp_click(ActionEvent event) {
    	
    	if(confirmpass_TF.getText().isEmpty() ||
    			userId_TF.getText().isEmpty() ||
    			password_TF.getText().isEmpty()) {
    		MyAlert alert = new MyAlert("Sign Up Error", 
    				"Look, an empty fields!", "Ooops, you must fill all the fields!", AlertType.ERROR);
			alert.showAndWait();
    	}
    	else if(!confirmpass_TF.getText().equals(password_TF.getText())){
    		MyAlert alert = new MyAlert("Sign Up Error", 
    				"Confirmation Password Error", "The confirm password doesn't match the password!", AlertType.ERROR);
			alert.showAndWait();
    	}
    	else {
    		Client newClient = new Client();
    		boolean signedUp = newClient.sign_up(userId_TF.getText(), password_TF.getText());
    		    		Client client = new Client();
    		client.sign_up(userId_TF.getText(), password_TF.getText());
    		if(!signedUp) {
    			MyAlert alert = new MyAlert("Sign Up Error", 
    					"UserID already in use.", "Please get another userID!", AlertType.ERROR);
    			alert.showAndWait();
    		}
    		else {
    			newClient.sign_up(userId_TF.getText(), password_TF.getText());
    			MyAlert alert = new MyAlert("Sign Up Information", 
    					"Sign up done successfully.", "Your are welocome.", AlertType.INFORMATION);
    			alert.showAndWait();
    		}
    	}
    }
}
