/**
 * Sample Skeleton for 'SignInAsEmployee.fxml' Controller Class
 */

package application;

import java.util.Vector;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class SignInAsEmployeeController {

	@FXML // fx:id="signIn_btn"
	private Button signIn_btn; // Value injected by FXMLLoader


	@FXML // fx:id="employeeID_TF"
	private TextField employeeID_TF; // Value injected by FXMLLoader

	@FXML // fx:id="password_TF"
	private PasswordField password_TF; // Value injected by FXMLLoader

	@FXML
	void signIn_click(ActionEvent event) {
		if(employeeID_TF.getText().isEmpty() ||
				password_TF.getText().isEmpty()) {
			MyAlert alert = new MyAlert("Sign in as employee Error", 
					"Look, an empty fields!", "Ooops, you must fill the fields!", AlertType.ERROR);
			alert.showAndWait();
		}
		else {

			//function connect as employee return string=role
			String role = "EP" ;
			role = new Employee().signIn(employeeID_TF.getText(), password_TF.getText());
			String fxmlWindow = null;
			int width=400,hieght=500;
			System.out.println(role);
			role.replaceAll("\n ", "");
			if(role.equals("CS")) {
				
				
				fxmlWindow = "CustomerServiceDepartmentEmployee.fxml";
				
				width = 500;
				hieght = 360;
			}
			//else if(role.equals("EP")) fxmlWindow = "EmployeeParking.fxml";
			else if(role.equals("NM")) {
				fxmlWindow = "NetworkManager.fxml";
				width = 500;
				hieght = 250;
			      Vector<Vector<String>> requests = new Employee().getChangeRatesRequests();
			      System.out.println(requests.size());
			      for(int i=0; i< requests.size(); i++) {
			    	  MyAlert alert = new MyAlert("Change Rates For Payment Request", "Request from the manager: " +
			    			  requests.get(i).get(0), requests.get(i).get(1), AlertType.CONFIRMATION);
			    	  ButtonType okButton = new ButtonType("Yes", ButtonData.YES);
			    	  ButtonType noButton = new ButtonType("NO", ButtonData.NO);
			    	  ButtonType cancelButton = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
			    	  alert.getButtonTypes().setAll(okButton, noButton, cancelButton);
			    	  alert.showAndWait();
			      }
			      
			}
			else if(role.equals("PM")) {
				fxmlWindow = "ParkingManager.fxml";
				width = 380;
				hieght = 180;
			}
			else if(role.equals("EP")) {
				fxmlWindow = "EmployeeParking.fxml";
				width = 400;
				hieght = 500;
			}
			else {
				MyAlert alert = new MyAlert("Sign in as employee Error", 
						"Connection Faild!","UserID or password is wrong!", AlertType.ERROR);
				alert.showAndWait();
			}
			MyWindow window = new MyWindow(fxmlWindow, "Sign In As Employee window", 
					"file:logo-login.png", width, hieght);
			
			window.setUserData(employeeID_TF.getText());
			window.view();

			Stage stage = (Stage)signIn_btn.getScene().getWindow();
			stage.close();
		}
	}
}
