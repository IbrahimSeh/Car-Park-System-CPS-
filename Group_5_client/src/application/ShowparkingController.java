


package application;

import java.awt.TextField;
import java.util.List;
import java.util.TreeMap;
import java.util.Vector;

import com.sun.prism.paint.Color;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;
import javafx.scene.paint.Paint;

public class ShowparkingController {


    @FXML
    private AnchorPane anchor;

    @FXML
    private TextField labl;

   public ShowparkingController() {
	 
	   Vector<Vector<Integer>> parkingStatus=  new Employee().currentParkingStatus("AmaniParking");
	   int hieght = parkingStatus.get(1).get(1);
	   int width = parkingStatus.get(1).get(2);
	   int depth = parkingStatus.get(1).get(3);
	   Path path = new Path();

	   Group root = new Group();
	      Stage stage = new Stage();
	      Rectangle r = new Rectangle(0,0,40,40);
	      r.setFill(javafx.scene.paint.Color.ORANGE);
	      //Setting title to the Stage
	      stage.setTitle("Drawing a Sphere"); 
	      root.getChildren().add(r);
	      
	      //Creating a scene object 
	      Scene scene = new Scene(root, 600, 300);
	      //Adding scene to the stage 
	      stage.setScene(scene); 
	         
	      //Displaying the contents of the stage 
	      stage.show();
	      
	   
	   /*
	      //Creating a SVGPath object 
	      SVGPath svgPath = new SVGPath();       
	       
	      String path = "M 100 100 L 300 100 L 200 300 z";  
	      
	      //Setting the SVGPath in the form of string 
	      svgPath.setContent(path);             
	         
	      //Creating a Group object  
	      Group root = new Group(svgPath); 
	               
	      //Creating a scene object 
	      Scene scene = new Scene(root, 600, 300);
	      
	      Stage stage = new Stage();
	      
	      //Setting title to the Stage
	      stage.setTitle("Drawing a Sphere"); 
	         
	      //Adding scene to the stage 
	      stage.setScene(scene); 
	         
	      //Displaying the contents of the stage 
	      stage.show();*/
	
   }
}
