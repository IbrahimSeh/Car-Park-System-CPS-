package application;

import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class MyAlert {

	private Alert alert;

	public MyAlert(String title, String headerText, String contentText, AlertType type) {
		alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.setContentText(contentText);
		
	}
	
	public void showAndWait(){
		alert.showAndWait();
	}
	
	public ObservableList<ButtonType> getButtonTypes() {
		return alert.getButtonTypes();
	}

}
