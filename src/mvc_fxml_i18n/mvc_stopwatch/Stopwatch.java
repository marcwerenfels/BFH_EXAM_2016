package mvc_fxml_i18n.mvc_stopwatch;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Stopwatch extends Stage {
		
	public Stopwatch(Timer timer, String color) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Stopwatch_"+color+".fxml"));
		Scene scene = new Scene((Parent) loader.load(), 350, 200);
		(loader.<Controller> getController()).init(timer);
		
		scene.getStylesheets().add(getClass().getResource(color+".css").toExternalForm());
		
		this.setTitle("Stopwatch");
		this.setScene(scene);
		this.show();
		
	}
	
	
}
