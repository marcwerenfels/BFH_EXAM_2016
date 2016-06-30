package mvc_fxml_i18n.i18n;

import java.io.IOException;
import java.net.URL;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

public class SimpleController implements Initializable {

	private ResourceBundle bundle;
	private DateTimeFormatter formatter;
	private NumberFormat numFormatter;
	private NumberFormat perFormatter;

	@FXML
	private Label label;
	@FXML
	private Label label2;
	@FXML
	private Label label3;

	// @Override
	public void initialize(URL location, ResourceBundle resources) {
		bundle = resources;
		formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
				.withLocale(bundle.getLocale());
		numFormatter = NumberFormat.getCurrencyInstance(bundle.getLocale());
		perFormatter = NumberFormat.getPercentInstance(bundle.getLocale());

		this.label.setText(MessageFormat.format(getI18nString("label.text"),
				new Object[] { formatter.format(LocalDate.now()) }));

		LocalTime now = LocalTime.now();
		this.label2.setText(MessageFormat.format(
				getI18nString("label2.text"), new Object[] { now.getHour(),
						now.getMinute() }));

		this.label3.setText(MessageFormat.format(
				getI18nString("label3.text"),
				new Object[] { numFormatter.format(Math.random() * 100) , perFormatter.format(Math.random())}));

	}

	@FXML
	protected void handleClickMe(ActionEvent event) {

		this.label.setText(MessageFormat.format(getI18nString("label.text"),
				new Object[] { formatter.format(LocalDate.now()) }));

		LocalTime now = LocalTime.now();
		this.label2.setText(MessageFormat.format(
				getI18nString("label2.text"), new Object[] { now.getHour(),
						now.getMinute() }));

		this.label3.setText(MessageFormat.format(
				getI18nString("label3.text"),
				new Object[] {numFormatter.format(Math.random() * 100) , perFormatter.format(Math.random())}));
	}

	@FXML
	protected void changeLanguageEN(ActionEvent event) {
		setLanguage("EN");
	}

	@FXML
	protected void changeLanguageDE(ActionEvent event) {
		setLanguage("DE");
	}
	
	private String getI18nString(String key) {
		try {
			return bundle.getString(key);
		} catch (MissingResourceException w) {
			System.err.println("Missing key "+key+" in "+bundle.getBaseBundleName());
			return "! "+key+" !";
		}
	}

	private void setLanguage(String string) {
		if ("EN".equals(string)) {
			bundle = ResourceBundle.getBundle("i18n.example", new Locale(
					"en", "GB"));
		} else {
			bundle = ResourceBundle.getBundle("i18n.example", new Locale(
					"de", "DE"));
		}

		FXMLLoader loader = new FXMLLoader(getClass().getResource("View.fxml"),
				bundle);

		try {

			Parent root = loader.load();

			Scene scene = this.label.getScene();
			Group g = (Group) scene.getRoot();
			g.getChildren().clear();
			g.getChildren().add(root);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
