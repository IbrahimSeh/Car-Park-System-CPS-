package application;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.stage.Stage;

public class MainWindowController {

    @FXML
    private Button SgnInEmployee;

    @FXML
    private Button SignInClient;

    @FXML
    void signInAsClient(ActionEvent event) throws IOException {
    	MyWindow window = new MyWindow("SignInAsClient.fxml", "Sign in as client Window",
    			"file:logo-login.png", 600, 400);
    	window.view();
    }

    @FXML
    void signInAsEmployee(ActionEvent event) {
    	MyWindow window = new MyWindow("SignInAsEmployee.fxml", "Sign in as Employee Window",
    			"file:employee-logo1.png", 580, 600);
    	window.view();
    	
    }

}
