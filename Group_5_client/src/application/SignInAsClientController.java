/**
 * Sample Skeleton for 'SignInAsClient.fxml' Controller Class
 */

package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class SignInAsClientController {

	private Client the_client = new Client();
    @FXML // fx:id="userIdTF"
    private TextField userIdTF; // Value injected by FXMLLoader

    @FXML // fx:id="connectBtn"
    private Button connectBtn; // Value injected by FXMLLoader

    @FXML // fx:id="password"
    private Label password; // Value injected by FXMLLoader

    @FXML // fx:id="passwordTF"
    private PasswordField passwordTF; // Value injected by FXMLLoader

    @FXML // fx:id="userId"
    private Label userId; // Value injected by FXMLLoader

    @FXML // fx:id="signUp_Btn"
    private Button signUp_Btn; // Value injected by FXMLLoader

    @FXML
    void connect_click(ActionEvent event) {
		if(userIdTF.getText().isEmpty() || passwordTF.getText().isEmpty())
		{
			MyAlert alert = new MyAlert("Connection Error", 
					"Look, an empty fields!" ,"Ooops, you must fill all the fields!", AlertType.ERROR);
			alert.showAndWait();
		}
		else {
			String userID = userIdTF.getText();
			String password = passwordTF.getText();
			boolean connected = the_client.connect(userID,password);		
			if(!connected) {
				MyAlert alert = new MyAlert("Connection Error", 
						"Connection Faild!" ,"UserID or password is wrong!", AlertType.ERROR);
				alert.showAndWait();
			}
			else {    			
				MyWindow window = new MyWindow("ClientServices.fxml", "Services for client", 
						"file:client-logo.jpg", 580, 600);
				window.view();
			}
		}
    }

    @FXML
    void signUpAsClient_click(ActionEvent event) {
		MyWindow window = new MyWindow("SignUpAsClient.fxml", "Sign up as client Window", 
				"file:signupIcon.png", 580, 600);
		window.view();
    }

}
