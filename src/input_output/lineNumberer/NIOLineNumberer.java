package input_output.lineNumberer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 * Reads all lines of a file and sends them to an output file, preceded by line
 * numbers.
 * Uses the NIO API available since Java 7
 * 
 * @author lua1
 */
public class NIOLineNumberer {
	public static void main(String[] args) throws IOException {
		Scanner console = new Scanner(System.in);
		System.out.print("Input file: ");
		String inputFileName = console.next();
		System.out.print("Output file: ");
		String outputFileName = console.next();
		console.close();

		Path in = Paths.get(inputFileName);

		Path out = Paths.get(outputFileName);
		
		List<String> lines = Files.readAllLines(in);
		
		for (int i=0; i<lines.size(); i++) {
			lines.set(i, "/* " + (i+1) + " */ " + lines.get(i));
			
			// Why don't the following 2 lines work ??
			//String s = lines.get(i);
			//s = "/* " + (i+1) + " */ " + s;
		}
		
		Files.write(out,lines);
		
		System.out.print("Done!");

	}
}
