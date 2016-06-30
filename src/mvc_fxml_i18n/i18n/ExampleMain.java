package mvc_fxml_i18n.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ExampleMain extends Application {

	private static ResourceBundle bundle;
	
	public static ResourceBundle getBundle() {
		return bundle;
	}

	@Override
	public void start(Stage primaryStage) {
		try {
						
		    bundle = ResourceBundle.getBundle(
					"i18n.example", new Locale("de","DE"));
			
		    FXMLLoader loader = new FXMLLoader(getClass().getResource("View.fxml"), bundle);
			
			Parent root = loader.load(); 	
			
			Group group = new Group(root);					
			
			Scene scene = new Scene(group);
			primaryStage.setTitle("I18n Example");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
