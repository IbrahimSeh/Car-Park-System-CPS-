/**
 * Sample Skeleton for 'SetUpNewParking.fxml' Controller Class
 */

package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sun.reflect.annotation.TypeAnnotation.TypeAnnotationTarget;

public class SetUpNewParkingController {

    @FXML // fx:id="hieght_TF"
    private TextField hieght_TF; // Value injected by FXMLLoader

    @FXML // fx:id="depth_TF"
    private TextField depth_TF; // Value injected by FXMLLoader

    @FXML // fx:id="parkingName_TF"
    private TextField parkingName_TF; // Value injected by FXMLLoader

    @FXML // fx:id="width_TF"
    private TextField width_TF; // Value injected by FXMLLoader
    
    @FXML // fx:id="cancel_btn"
    private Button cancel_btn; // Value injected by FXMLLoader
    
    @FXML // fx:id="submit_btn"
    private Button submit_btn; // Value injected by FXMLLoader
    

    @FXML
    void submit_click(ActionEvent event) {
    	String res=new Employee().SetUpNewParking(parkingName_TF.getText(), depth_TF.getText(), width_TF.getText(), hieght_TF.getText());
    	MyAlert setUpResult =  new MyAlert("Setting Up New Park Result", "Result", res, AlertType.INFORMATION);
    	setUpResult.showAndWait();
    }

    @FXML
    void cancel_click(ActionEvent event) {
    	Stage stage = (Stage)cancel_btn.getScene().getWindow();
    	stage.close();
    }

}
