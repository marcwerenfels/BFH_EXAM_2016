package input_output.lineNumberer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Reads all lines of a file and sends them to an output file, preceded by line
 * numbers.
 * 
 * @author lua1
 */
public class LineNumberer {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner console = new Scanner(System.in);
		System.out.print("Input file: ");
		String inputFileName = console.next();
		System.out.print("Output file: ");
		String outputFileName = console.next();
		console.close();

		FileReader reader = new FileReader(inputFileName);

		Scanner in = new Scanner(reader);
		PrintWriter out = new PrintWriter(outputFileName);
		int lineNumber = 1;

		while (in.hasNextLine()) {
			String line = in.nextLine();
			out.println("/* " + lineNumber + " */ " + line);
			lineNumber++;
		}

		out.close();
		in.close();

		System.out.print("Done!");

	}
}
