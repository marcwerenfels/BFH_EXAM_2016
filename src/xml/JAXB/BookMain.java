package xml.JAXB;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public final class BookMain {

	public static void main(String[] args) throws JAXBException, IOException {

		BookStore bookStore = new BookStore("Luethy Bookstore", "Mainstreet Bienne");

		// create books
		Book book1 = new Book();
		book1.setIsbn("999-0061854736");
		book1.setName("Der Verdacht");
		book1.setAuthor("Friedrich Duerrenmatt");
		book1.setPublisher("Wander");
		bookStore.add(book1);

		Book book2 = new Book();
		book2.setIsbn("912-3832223457");
		book2.setName("The man and the see");
		book2.setAuthor("Jean De Motta");
		book2.setPublisher("Rororo");
		bookStore.add(book2);

		Book book3 = new Book();
		book3.setIsbn("112-3855223457");
		book3.setName("Donald Duck");
		book3.setAuthor("Walt Disney");
		book3.setPublisher("Rororo");
		bookStore.add(book3);

		// create JAXB context and instantiate marshaller
		JAXBContext context = JAXBContext.newInstance(BookStore.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		// Write to System.out
		m.marshal(bookStore, System.out);

		// Write to File
		m.marshal(bookStore, new File("bookstore.xml"));

		// Output result from XML File
		Unmarshaller um = context.createUnmarshaller();
		BookStore bookStore2 = (BookStore) um.unmarshal(new FileReader(
				"bookstore.xml"));

		ArrayList<Book> list = bookStore2.getBooksList();
		if (list != null) {
			for (Book book : list)
				System.out.println("Book: " + book.getName() + " from " + book.getAuthor());
		}
	}
}
