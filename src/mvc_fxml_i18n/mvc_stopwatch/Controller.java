package mvc_fxml_i18n.mvc_stopwatch;

import java.util.Observable;
import java.util.Observer;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller implements Observer{
	
	private Timer timer;
	
	@FXML
	private Button start, stop, reset;
	
	@FXML
	private Label timeLabel, statusBar;
	
	public void init(Timer timer) {
		this.timer = timer;
		this.timer.addObserver(this);
	}
	
	@FXML
	protected void handleStart(ActionEvent event) {
		this.timer.start();
	}
	@FXML
	protected void handleStop(ActionEvent event) {
		this.timer.stop();
	}
	@FXML
	protected void handleReset(ActionEvent event) {
		this.timer.reset();
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		Platform.runLater(new Runnable(){
			@Override
			public void run() {
				timeLabel.setText(timer.getTimeString());
				start.setDisable(timer.isRunning());
				stop.setDisable(!timer.isRunning());
				reset.setDisable(timer.isRunning());
				statusBar.setText(timer.isRunning() ? "Running..." : "Stopped");
			}
		});
		
	}
}
