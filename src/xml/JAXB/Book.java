package xml.JAXB;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "BookItem", propOrder = { "author", "name", "publisher", "isbn" })
public class
Book {
	
	private String name;
	private String author;
	private String publisher;
	private String isbn;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
}
