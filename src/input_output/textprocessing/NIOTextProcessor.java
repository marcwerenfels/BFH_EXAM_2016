package input_output.textprocessing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author lua1
 *
 */
public class NIOTextProcessor {
	
	public static void main(String[] args) throws IOException {

		Path inputFile = Paths.get("worldarea.txt");

		List<String> lines = Files.readAllLines(inputFile);
		
		for (String line : lines) {
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
	}
}
