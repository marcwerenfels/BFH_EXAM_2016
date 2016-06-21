import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author lua1
 *
 */
public class TextProcessor2 {
	
	public static void main(String[] args) throws IOException {

		FileReader reader = new FileReader("worldarea.txt");
		Scanner in = new Scanner(reader);
	
		while (in.hasNext()) {
			String line = in.nextLine();
		    String[] items = line.split("\t");
		    
	    	String countryName = new String("");
	    	String areaString = new String("0");

		    if (items.length >= 1) {
		    	countryName = items[0].trim();
		    }	
		    if (items.length >= 2) {
		    	areaString = items[1];
		    }	
			Integer area = Integer.parseInt(areaString);

			System.out.println("Country: <" + countryName + "> Area: " + area);
		}
		reader.close();
		in.close();
	}
}
