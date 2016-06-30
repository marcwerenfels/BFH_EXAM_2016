package mvc_fxml_i18n.mvc_stopwatch;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {

		Timer timer = new Timer(500);
		new Stopwatch(timer, "yellow");
		
		//Timer timer2 = new Timer(100);
		new Stopwatch(timer, "blue");
	}
	

	public static void main(String[] args) {
		launch(args);
	}
}