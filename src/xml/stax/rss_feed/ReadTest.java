package xml.stax.rss_feed;

public final class ReadTest {
  private ReadTest(){}

  public static void main(String[] args) {
    RSSFeedParser parser = new RSSFeedParser("http://www.blick.ch/news/rss");
    Feed feed = parser.readFeed();
    System.out.println(feed);
    for (FeedMessage message : feed.getMessages()) System.out.println(message);
  }
} 