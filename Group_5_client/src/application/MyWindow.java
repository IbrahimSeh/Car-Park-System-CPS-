package application;

import java.io.IOException;
import java.util.Map;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.stage.Stage;

public class MyWindow {
	
	private Stage stage;
	private AnchorPane root;
	
	public MyWindow(String fxmlFile,String title,String imageName,double width, double hieght) {
		
    	
		try {		
			root = (AnchorPane)FXMLLoader.load(getClass().getResource(fxmlFile));
			stage = new Stage();
			stage.setTitle(title);
			Scene scene = new Scene(root,width,hieght);
			stage.setScene(scene);	
			stage.setResizable(false);
			Image icon = new Image(imageName);
			stage.getIcons().add(icon);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setUserData(String userID) {
		stage.setUserData(userID);
	}
	
	public void view() {
		stage.show();
	}
	
	public void setBackground(String imageName){
		Image image = new Image(imageName,600,400, false, false);
		root.setBackground(new Background(new BackgroundImage(image, null, null, null, null)));
		
	}
	

}




