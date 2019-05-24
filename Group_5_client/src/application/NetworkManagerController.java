/**
 * Sample Skeleton for 'NetworkManager.fxml' Controller Class
 */

package application;

import java.util.Iterator;
import java.util.Vector;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class NetworkManagerController {

    @FXML // fx:id="Current_btn"
    private Button Current_btn; // Value injected by FXMLLoader

    @FXML // fx:id="Setting_btn"
    private Button Setting_btn; // Value injected by FXMLLoader

    @FXML
    void currentParkingStatus_Click(ActionEvent event) {
    /*	MyWindow window = new MyWindow("showparking.fxml", "parking status window.", 
    			"file:settingtherateforpaymenticon.png", 500, 280);
    	window.view();*/
 	  Vector<Vector<Integer>> parkingStatus=  new Employee().currentParkingStatus("AmaniParking");
	  int hieght = parkingStatus.get(0).get(0);
	  
	  int width = parkingStatus.get(0).get(1);
	  
	  int depth = parkingStatus.get(0).get(2);
	  System.out.println(hieght + " " + width + " " + depth);
	  
	//Creating a Path 
      Pane path = new Pane();
      int w1,h1,d1;
      
      for(int i=0; i<hieght*width*depth; i++) {
    	  h1 = parkingStatus.get(i).get(3);
    	  d1 = parkingStatus.get(i).get(4);
    	  w1 = parkingStatus.get(i).get(5);
    	  
    	  Rectangle r = new Rectangle((w1+3)*40 ,h1*depth*40 +d1*40 ,35,35);  
    	  Color color;
    	  if(parkingStatus.get(i).get(6)==1) color = Color.FUCHSIA;  //there is a car
    	  else if(parkingStatus.get(i).get(6)==2) color = Color.RED; //there is a problem
    	  else if(parkingStatus.get(i).get(6)==3) color = Color.BLUE; //saved
    	  else color = Color.GREEN;
		  r.setFill(color);
		  path.getChildren().add(r);  
    	  
    	  Label label = new Label();
    	  label.setText("floor " + h1 + ": ");
    	  label.setFont(Font.font("Cambria", 32));
    	  label.relocate(0, h1*depth*40);
    	  path.getChildren().add(label);
      }
      
      Label label1 = new Label();
      label1.setText("Empty");
      label1.setFont(Font.font("Cambria", 10));
	  label1.relocate(700,0);
	  path.getChildren().add(label1);
	  
	  Circle emptyCircle = new Circle(680,7, 4);
	  emptyCircle.setFill(Color.GREEN);
	  path.getChildren().add(emptyCircle);

	  
	  Label label2 =  new Label();
      label2.setText("Problem");
      label2.setFont(Font.font("Cambria", 10));
	  label2.relocate(700,15);
	  path.getChildren().add(label2);
	  
	  Circle problemCircle = new Circle(680,22 ,4);
	  problemCircle.setFill(Color.RED);
	  path.getChildren().add(problemCircle);

	  Label label3 =  new Label();
      label3.setText("Saved");
      label3.setFont(Font.font("Cambria", 10));
	  label3.relocate(700,30);
	  path.getChildren().add(label3);
	  
	  Circle savedCircle = new Circle(680,37, 4);
	  savedCircle.setFill(Color.BLUE);
	  path.getChildren().add(savedCircle);
	  
	  Label label4 =  new Label();
      label4.setText("car exist");
      label4.setFont(Font.font("Cambria", 10));
	  label4.relocate(700,45);
	  path.getChildren().add(label4);
	  
	  Circle carExistCircle = new Circle(680,52, 4);
	  carExistCircle.setFill(Color.FUCHSIA);
	  path.getChildren().add(carExistCircle);
      
      ScrollPane sp = new ScrollPane(path);
         
      //Creating a scene object 
      Scene scene = new Scene(sp, 800, 600);  
      
      Stage stage = new Stage();
      //Setting title to the Stage 
      stage.setTitle("Current Status Of Parking");
      
      //Adding scene to the stage 
      stage.setScene(scene);
      Image icon = new Image("file:eyeIcon.png");
      stage.getIcons().add(icon);
      
      //Displaying the contents of the stage 
      stage.show();  
      

      
     
    }

    @FXML
    void settingRates_Click(ActionEvent event) {
    	MyWindow window = new MyWindow("SettingTheRateForPayment.fxml", "Setting The Rate For Payment Window", 
				"file:settingtherateforpaymenticon.png", 500, 280);
		window.view();
    }

}
