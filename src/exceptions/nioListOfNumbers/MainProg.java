package exceptions.nioListOfNumbers;

public class MainProg {

	/**
	 * @param args unused
	 */
	public static void main(String[] args) {

		NIOListOfNumbers list = new NIOListOfNumbers();	
		list.readList("InFile.txt");
		list.writeList();		
		System.out.println("Done !!");
				
	}

}
