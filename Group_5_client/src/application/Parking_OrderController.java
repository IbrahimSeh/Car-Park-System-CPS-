/**
 * Sample Skeleton for 'Parking_Order.fxml' Controller Class
 */

package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Parking_OrderController {

    @FXML // fx:id="end_date"
    private DatePicker end_date; // Value injected by FXMLLoader

    @FXML // fx:id="requestedLot_TF"
    private TextField requestedLot_TF; // Value injected by FXMLLoader

    @FXML // fx:id="carNum_TF"
    private TextField carNum_TF; // Value injected by FXMLLoader

    @FXML // fx:id="beginningTime_TF"
    private TextField beginningTime_TF; // Value injected by FXMLLoader

    @FXML // fx:id="Order_kind"
    private ToggleGroup Order_kind; // Value injected by FXMLLoader

    @FXML // fx:id="endTime_TF"
    private TextField endTime_TF; // Value injected by FXMLLoader

    @FXML // fx:id="localParkOrder_radio"
    private RadioButton localParkOrder_radio; // Value injected by FXMLLoader

    @FXML // fx:id="subscribeMonthly_radio"
    private RadioButton subscribeMonthly_radio; // Value injected by FXMLLoader

    @FXML // fx:id="email_TF"
    private TextField email_TF; // Value injected by FXMLLoader

    @FXML // fx:id="oneTimeParkingOrder_radio"
    private RadioButton oneTimeParkingOrder_radio; // Value injected by FXMLLoader

    @FXML // fx:id="start_date"
    private DatePicker start_date; // Value injected by FXMLLoader

    @FXML // fx:id="submit_btn"
    private Button submit_btn; // Value injected by FXMLLoader
    
    @FXML
    private Button cancel_btn;

    Client client = new Client();
    
    @FXML
    void submit_click(ActionEvent event) {
    	String result = null;
    	if(localParkOrder_radio.isPressed()) result = localParkOrder();
    	else if(subscribeMonthly_radio.isPressed()) result = SubscribeMonthlyParking();
    	else if(oneTimeParkingOrder_radio.isPressed()) result = onewTimeParking();
    	
    	MyAlert alert = new MyAlert("Parking Order Result:", 
    			"The result of parking order is:", result, AlertType.INFORMATION);
		alert.showAndWait();    	
    }
    
    @FXML
    void oneTimeParkingOrder_click(ActionEvent event) {
    	beginningTime_TF.setVisible(true);
    	endTime_TF.setVisible(true);
    	end_date.setVisible(true);
    	requestedLot_TF.setVisible(true);
    }
    
    String onewTimeParking() {
    	return client.oneTimeParkingOrder(email_TF.getText(),carNum_TF.getText(), start_date.toString(), beginningTime_TF.getText(),
    	end_date.toString(), endTime_TF.getText(), requestedLot_TF.getText());	
    }

    @FXML
    void subscribeMonthly_click(ActionEvent event) {
    	beginningTime_TF.setVisible(false);
    	endTime_TF.setVisible(false);
    	end_date.setVisible(false);
    	requestedLot_TF.setVisible(true);
    }

    String SubscribeMonthlyParking() {
    	return client.subscribeMonthly(email_TF.getText(),carNum_TF.getText(), start_date.toString());
    	
	}
    
    @FXML
    void localParkOrder_click(ActionEvent event) {
    	beginningTime_TF.setVisible(true);
    	endTime_TF.setVisible(true);
    	end_date.setVisible(true);
    	requestedLot_TF.setVisible(false);
    }
    
    String localParkOrder() {
    	return client.parkingOrderLocalPark(email_TF.getText(),carNum_TF.getText(), start_date.toString(),
    			beginningTime_TF.getText(), end_date.toString(), endTime_TF.getText());
    }


    @FXML
    void getStartDate(ActionEvent event) {

    }

    @FXML
    void getEndDate(ActionEvent event) {

    }
    
    @FXML
    void cancel_click(ActionEvent event) {
    	Stage stage = (Stage)cancel_btn.getScene().getWindow();
    	stage.close();
    }

}
