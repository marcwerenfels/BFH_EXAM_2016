package mvc_fxml_i18n.dateAndTimeFormatter;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by TGDWEMAR on 12.04.2016.
 */
public class DateTimeFormat {

    public static void main(String[] args) {
        Locale[] locales = {Locale.ENGLISH, Locale.FRENCH, Locale.GERMAN};
        int[] sizes = {DateFormat.SHORT, DateFormat.MEDIUM, DateFormat.LONG, DateFormat.FULL};

        for (Locale locale : locales) {
            for (int size : sizes) {
                DateFormat timeFormatter = DateFormat.getDateTimeInstance(size, size, locale);
                System.out.println(timeFormatter.format(new Date()));
            }
            System.out.println("------------------------------");
        }

    }
}
