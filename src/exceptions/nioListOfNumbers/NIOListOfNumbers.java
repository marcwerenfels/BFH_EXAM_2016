package exceptions.nioListOfNumbers;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class NIOListOfNumbers {

	private Vector<Integer> victor;
	private static final int SIZE = 10;

	public NIOListOfNumbers() {
		victor = new Vector<Integer>(SIZE);
		for (int i = 0; i < SIZE; i++)
			victor.addElement(new Integer(i));
	}

	public void writeList() {

		List<String> lines = new ArrayList<String>();

		for (int i = 0; i < victor.size(); i++)
			lines.add("Value at: " + i + " = " + victor.elementAt(i));

		try {
			Files.write(Paths.get("OutFile.txt"), lines);
		} catch (InvalidPathException e) {
			System.err
					.println("Caught InvalidPathException: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}

	}

	public void readList(String fileName) {

		try {
			List<String> lines = Files.readAllLines(Paths.get(fileName));

			for (String line : lines) {
				Integer i = new Integer(Integer.parseInt(line));
				System.out.println(i);
				victor.addElement(i);
			}

		} catch (NumberFormatException fnf) {
			System.err.println("File: " + fileName + " erroneous.");
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}
}
