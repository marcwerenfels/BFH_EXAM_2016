package xml.stax;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public final class StAXParser {

	/**
	 * Based on the Item class:
	 */

	static final String DATE = "date";
	static final String ITEM = "item";
	static final String MODE = "mode";
	static final String UNIT = "unit";
	static final String CURRENT = "current";
	static final String INTERACTIVE = "interactive";

	public List<Item> readConfig(String configFile) {
		List<Item> items = new ArrayList<Item>();
		try (InputStream in = new FileInputStream(configFile)) {
			// First, create a new XMLInputFactory
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();

			// Setup a new eventReader
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);

			// prepare a Item reference
			Item item = null;

			// loop over all events
			while (eventReader.hasNext()) {

				// get the next event
				XMLEvent event = eventReader.nextEvent();

				// process only events of interest 
				if (event.isStartElement()) {

					// convert to Start element
					StartElement startElement = event.asStartElement();

					// if we have an item element, we create a new item
					if (startElement.getName().getLocalPart().equals(ITEM)) {
						item = new Item();

						// We read the attributes from this tag and add
						// the date attribute to our object
						// get an iterator to iterate over
						// the attributes list
						@SuppressWarnings("unchecked")
						Iterator<Attribute> attributes = startElement.getAttributes();
						while (attributes.hasNext()) {
							// get one after the other
							Attribute attribute = attributes.next();
							if (attribute.getName().toString().equals(DATE))
								// set the field in item
								item.setDate(attribute.getValue());
						}
					} else
					// treat the rest
					if (startElement.getName().getLocalPart().equals(MODE)) {
						event = eventReader.nextEvent();
						item.setMode(event.asCharacters().getData());
						continue;
					} else if (startElement.getName().getLocalPart()
							.equals(UNIT)) {
						event = eventReader.nextEvent();
						item.setUnit(event.asCharacters().getData());
						continue;
					} else if (startElement.getName().getLocalPart()
							.equals(CURRENT)) {
						event = eventReader.nextEvent();
						item.setCurrent(event.asCharacters().getData());
						continue;
					} else if (startElement.getName().getLocalPart()
							.equals(INTERACTIVE)) {
						event = eventReader.nextEvent();
						item.setInteractive(event.asCharacters().getData());
						continue;
					}
				} else
				// if we reach the end of an item element, we add it to the list
				if (event.isEndElement()) {
					EndElement endElement = event.asEndElement();
					// it must be an ITEM tag
					if (endElement.getName().getLocalPart() == (ITEM))
						items.add(item);
				}
			}
		
		} catch (XMLStreamException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return items;
	}
}
