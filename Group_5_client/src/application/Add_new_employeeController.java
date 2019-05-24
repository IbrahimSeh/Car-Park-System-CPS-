/**
 * Sample Skeleton for 'Add_new_employee.fxml' Controller Class
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

public class Add_new_employeeController {

	 @FXML // fx:id="emppostTf"
	    private TextField emppostTf; // Value injected by FXMLLoader

	    @FXML // fx:id="Role_TF"
	    private Label Role_TF; // Value injected by FXMLLoader

	    @FXML // fx:id="titleL"
	    private Label titleL; // Value injected by FXMLLoader

	    @FXML // fx:id="empidL"
	    private Label empidL; // Value injected by FXMLLoader

	    @FXML // fx:id="empidTf"
	    private TextField empidTf; // Value injected by FXMLLoader

	    @FXML // fx:id="submitBn"
	    private Button submitBn; // Value injected by FXMLLoader

	    @FXML // fx:id="nameL"
	    private Label nameL; // Value injected by FXMLLoader

	    @FXML // fx:id="password_Tf"
	    private TextField password_Tf; // Value injected by FXMLLoader

	    @FXML // fx:id="cancelBn"
	    private Button cancelBn; // Value injected by FXMLLoader

	@FXML
	void Submit_add_emp_click(ActionEvent event) {
		if(empidTf.getText().isEmpty() || Role_TF.getText().isEmpty() || password_Tf.getText().isEmpty()) {	
			MyAlert alert = new MyAlert("Adding a new employee Error", 
					"Look, an empty fields!", "Ooops, you must fill the fields!", AlertType.ERROR);
			alert.showAndWait();
		}
		else {

			Employee newEmployey = new Employee();
    		Stage stage = (Stage)empidTf.getScene().getWindow();
        	String userID = stage.getUserData().toString();
        	String parkingName = newEmployey.getParkingNameOfEmployee(userID);
        	System.out.println("aaaaaaaaaa");
        	System.out.println(parkingName);
			boolean signedUp = newEmployey.AddNewEmployee(empidTf.getText(),
					password_Tf.getText(),emppostTf.getText(), parkingName);
			if(!signedUp) {
				MyAlert alert = new MyAlert("Adding a new employee Error", 
						"User ID already exist!", "Ooops, you must choose another user Id.", AlertType.ERROR);
				alert.showAndWait();
			}else {
				MyAlert alert = new MyAlert("Adding a new employee Result", 
						"Result:", "Adding the new employee done successfully.", AlertType.INFORMATION);
				alert.showAndWait();
			}
		}

	}

	@FXML
	void Cancel_add_emp_click(ActionEvent event) {
		Stage stage = (Stage)cancelBn.getScene().getWindow();
		stage.close();
	}

}
