import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author lua1
 *
 */
public class TextProcessor1 {

	public static void main(String[] args) throws IOException {

		FileReader reader = new FileReader("worldarea.txt");
		Scanner in = new Scanner(reader);

		while (in.hasNext()) {
			String line = in.nextLine();

			int i = 0;
			while (!Character.isDigit(line.charAt(i))) {
				i++;
			}

			String countryName = line.substring(0, i).trim();
			String areaString = line.substring(i);
			Integer area = Integer.parseInt(areaString);

			System.out.println("Country: <" + countryName + "> Area: " + area);	
		}
		reader.close();
		in.close();
	}
}
