package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ReportController {

	@FXML
	private Button cancel_btn;

	@FXML
	private Label id_btn;

	@FXML
	private TextArea Text_TF;

	@FXML
	private Label Text_btn;

	@FXML
	private Button send_btn;

	@FXML
	private TextField txtid_TF;

	@FXML
	private ImageView report_im;

	@FXML
	void send_click(ActionEvent event) {
		if(txtid_TF.getText().isEmpty()) {
			MyAlert alert = new MyAlert("Report Error", 
					"Ooops, you must fill the field!", "Ooops, you must fill the field!", AlertType.ERROR);
			alert.showAndWait();  
		}
		else {
			Client client = new Client();
			String result = client.send_report(txtid_TF.getText());
			MyAlert alert = new MyAlert("Reporting Result:", 
					"The result of Report:", result, AlertType.INFORMATION);
			alert.showAndWait();
		}
	}

	@FXML
	void cancel_click(ActionEvent event) {
		Stage stage = (Stage)cancel_btn.getScene().getWindow();
		stage.close();
	}
}
