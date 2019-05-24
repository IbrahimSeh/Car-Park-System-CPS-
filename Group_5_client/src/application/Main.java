package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			ImageView iv = new ImageView();
			Image image = new Image("file:main window poster.jpg");
			iv.setImage(image);
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
			Scene scene = new Scene(root,600,350);
			root.setBackground(new Background(new BackgroundImage(image, null, null, null, null)));
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Image icon = new Image("file:Car Parking Sign.jpg");
			primaryStage.setTitle("CPS Group5");
			primaryStage.getIcons().add(icon);
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
