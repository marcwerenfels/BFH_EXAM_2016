package xml.stax.rss_feed;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class RSSFeedParser {

    private XMLInputFactory inputFactory = XMLInputFactory.newInstance();
    private InputStream in;

    public RSSFeedParser(String rss_url) {
        try {
            URL url = new URL(rss_url);
            this.in = url.openStream();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public RSSFeedParser(URL url) {
        try {
            this.in = url.openStream();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public Feed readFeed() {
        String header_title = "";
        String header_link = "";
        String header_description = "";
        String header_language = "";
        String header_copyright = "";
        String header_pubDate = "";

        String item_title = "";
        String item_description = "";
        String item_link = "";
        String item_guid = "";
        String item_author = "";

        Feed feed = null;

        try {
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);

            boolean isFeedHeader = true;
            while (eventReader.hasNext()){
                XMLEvent event = eventReader.nextEvent();
                switch (event.getEventType()){
                    case XMLEvent.START_ELEMENT:
                        if (event.asStartElement().getName().toString().equals("item") &&  isFeedHeader) {
                            isFeedHeader = false;
                            feed = new Feed(header_title, header_link, header_description, header_language, header_copyright, header_pubDate);
                        }
                        if (event.asStartElement().getName().toString().equals("title")){
                            if (isFeedHeader) {
                                header_title = eventReader.nextEvent().asCharacters().toString();
                            } else {
                                item_title = eventReader.nextEvent().asCharacters().toString();
                            }
                        }
                        if (event.asStartElement().getName().toString().equals("link")){
                            if (isFeedHeader) {
                                header_link = eventReader.nextEvent().asCharacters().toString();
                            } else {
                                item_link = eventReader.nextEvent().asCharacters().toString();
                            }
                        }
                        if (event.asStartElement().getName().toString().equals("description")){
                            if (isFeedHeader) {
                                header_description = eventReader.nextEvent().asCharacters().toString();
                            } else {
                                item_description = eventReader.nextEvent().asCharacters().toString();
                            }
                        }
                        if (event.asStartElement().getName().toString().equals("language")){
                            if (isFeedHeader) {
                                header_language = eventReader.nextEvent().asCharacters().toString();
                            }
                        }
                        if (event.asStartElement().getName().toString().equals("copyright")){
                            if (isFeedHeader) {
                                header_copyright = eventReader.nextEvent().asCharacters().toString();
                            }
                        }
                        if (event.asStartElement().getName().toString().equals("pubDate")){
                            if (isFeedHeader) {
                                header_pubDate = eventReader.nextEvent().asCharacters().toString();
                            }
                        }
                        if (event.asStartElement().getName().toString().equals("guid")){
                            item_guid = eventReader.nextEvent().asCharacters().toString();
                        }
                        break;
                    case XMLEvent.CHARACTERS:
                        break;
                    case XMLEvent.END_ELEMENT:
                        if (event.asEndElement().getName().toString().equals("item")){
                            if (!isFeedHeader){
                                FeedMessage feedMessage = new FeedMessage();
                                feedMessage.setAuthor("wtf");
                                feedMessage.setDescription(item_description);
                                feedMessage.setGuid(item_guid);
                                feedMessage.setLink(item_link);
                                feedMessage.setTitle(item_title);
                                feed.addMessage(feedMessage);
                            }
                        }
                        break;
                }
            }
        } catch (XMLStreamException e){
            e.printStackTrace();
        }

        return feed;
    }
}
