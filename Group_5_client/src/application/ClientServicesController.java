package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ClientServicesController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button CancelOrder_btn;

	@FXML
	private Button CheckOrderStatus_btn;

	@FXML
	private Button InsertingTheCar_btn;

	@FXML
	private Button Report_ptn;

	@FXML
	private Button TakingOutTheCar_btn;

	@FXML
	private Button parkingOrder_btn;

	@FXML
	void CancelOrder_click(ActionEvent event) {
		MyWindow window = new MyWindow("CancelOrder.fxml", "Cancel Order Window", "file:cancel-orderIcon.png",600, 400);
		window.setBackground("file:cancel-order.jpg");
		window.view();
	}

	@FXML
	void CheckOrderStatus_click(ActionEvent event) {
		MyWindow window = new MyWindow("CheckOrderStatus.fxml", "Check Order Status", "file:CheckOrderStatusicon.jpg",410, 350);
		window.view();
	}

	@FXML
	void InsertingTheCar_click(ActionEvent event) {
		MyWindow window = new MyWindow("Insert_the_car.fxml", "Inserting The Car", "file:parking_logo.jpg",410, 400);
		window.view();
	}

	@FXML
	void Report_click(ActionEvent event) {
		MyWindow window = new MyWindow("Report.fxml", "Report", "file:Reporticon.png",420, 450);
		window.view();
	}

	@FXML
	void TakingOutTheCar_click(ActionEvent event) {
		MyWindow window = new MyWindow("Taking_out_the_car.fxml", "Taking Out The Car", "file:out.png",410, 420);
		window.view();
	}

	@FXML
	void parkingOrder_click(ActionEvent event) {
		MyWindow window = new MyWindow("Parking_Order.fxml", "Parking Order Form", "file:order.icon.png",650, 600);
		window.view();
	}

	@FXML
	void initialize() {
		assert CancelOrder_btn != null : "fx:id=\"CancelOrder_btn\" was not injected: check your FXML file 'ClientServices.fxml'.";
		assert CheckOrderStatus_btn != null : "fx:id=\"CheckOrderStatus_btn\" was not injected: check your FXML file 'ClientServices.fxml'.";
		assert InsertingTheCar_btn != null : "fx:id=\"InsertingTheCar_btn\" was not injected: check your FXML file 'ClientServices.fxml'.";
		assert Report_ptn != null : "fx:id=\"Report_ptn\" was not injected: check your FXML file 'ClientServices.fxml'.";
		assert TakingOutTheCar_btn != null : "fx:id=\"TakingOutTheCar_btn\" was not injected: check your FXML file 'ClientServices.fxml'.";
		assert parkingOrder_btn != null : "fx:id=\"parkingOrder_btn\" was not injected: check your FXML file 'ClientServices.fxml'.";

	}

}
