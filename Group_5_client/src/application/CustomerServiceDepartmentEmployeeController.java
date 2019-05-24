package application;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javax.swing.text.html.HTMLDocument.Iterator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;


public class CustomerServiceDepartmentEmployeeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    public TextField Amount_Tf;

    @FXML
    private TextField Client_TF;

    @FXML
    private Button Submit_btn;

    @FXML
    private TextArea show_TF;


    @FXML
    void submit_Click(ActionEvent event) {
     HashMap< String , String> reports=new Employee().GetRepo();
     java.util.Iterator<String> it=reports.keySet().iterator();
     
     while(it.hasNext()) {
    	String itv=it.next();
    	 show_TF.appendText("\n "+itv+": "+reports.get(itv));
     }
     
    	
    }

    @FXML
    void initialize() {
        assert Amount_Tf != null : "fx:id=\"Amount_Tf\" was not injected: check your FXML file 'CustomerServiceDepartmentEmployee.fxml'.";
        assert Client_TF != null : "fx:id=\"Client_TF\" was not injected: check your FXML file 'CustomerServiceDepartmentEmployee.fxml'.";
        assert Submit_btn != null : "fx:id=\"Submit_btn\" was not injected: check your FXML file 'CustomerServiceDepartmentEmployee.fxml'.";
        assert show_TF != null : "fx:id=\"show_TF\" was not injected: check your FXML file 'CustomerServiceDepartmentEmployee.fxml'.";


    }

}
