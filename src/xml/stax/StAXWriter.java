package xml.stax;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public final class StAXWriter{

  private String configFile;

  public void setFile(String configFile) {this.configFile = configFile;}

  public void saveConfig() {
    // create an XMLOutputFactory
    XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
    
    try (OutputStream out = new FileOutputStream(configFile)) {
    // create XMLEventWriter
    XMLEventWriter eventWriter = outputFactory
        .createXMLEventWriter(out);
    
    // create an EventFactory
    XMLEventFactory eventFactory = XMLEventFactory.newInstance();
    XMLEvent end = eventFactory.createCharacters("\n");   
    
    // create and write Start Tag
    StartDocument startDocument = eventFactory.createStartDocument();
    eventWriter.add(startDocument);
    eventWriter.add(end);

    // create config open tag
    StartElement configStartElement = eventFactory.createStartElement("","", "config");
    eventWriter.add(configStartElement);
    eventWriter.add(end);
    
    // create item open tag
    StartElement itemElem = eventFactory.createStartElement("", "", "item");
    eventWriter.add(itemElem);
        // Add attribute
    eventWriter.add(eventFactory.createAttribute("date", "March 2015"));
    eventWriter.add(end);
    
    // write the different nodes
    createNode(eventWriter, "mode", "1");
    createNode(eventWriter, "unit", "901");
    createNode(eventWriter, "current", "0");
    createNode(eventWriter, "interactive", "0");

    eventWriter.add(eventFactory.createEndElement("", "", "item"));
    eventWriter.add(end);
    eventWriter.add(eventFactory.createEndElement("", "", "config"));
    eventWriter.add(end);
    eventWriter.add(eventFactory.createEndDocument());
    } catch (IOException e) {
		e.printStackTrace();
	} catch (XMLStreamException e) {
		e.printStackTrace();
	}   
  }

  

  private void createNode(XMLEventWriter eventWriter, String elementTag,
      String value) throws XMLStreamException {

    XMLEventFactory eventFactory = XMLEventFactory.newInstance();
    XMLEvent end = eventFactory.createCharacters("\n"); 
    XMLEvent tab = eventFactory.createCharacters("\t"); 
    
    // create Start node
    StartElement sElement = eventFactory.createStartElement("", "", elementTag);
    eventWriter.add(tab);
    eventWriter.add(sElement);
    
    // create Content
    Characters characters = eventFactory.createCharacters(value);
    eventWriter.add(characters);
    
    // create End node
    EndElement eElement = eventFactory.createEndElement("", "", elementTag);
    eventWriter.add(eElement);
    eventWriter.add(end);
  }
} 
