package xml.stax;
import java.util.List;

public class ReadTest {

	private ReadTest() {};

	public static void main(String args[]) {
		StAXParser read = new StAXParser();
		List<Item> readConfig = read.readConfig("config.xml");
		for (Item item : readConfig) System.out.println(item);
		
	}
}

