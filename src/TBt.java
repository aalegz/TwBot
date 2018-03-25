

public class TBt {
    public static void main(String[] args){
        XMLFeedParser xmlFeedVovo = new XMLFeedParser("https://www.anekdot.ru/rss/tag/2.xml");
        xmlFeedVovo.xmlParse();
        XMLFeedParser xmlFeedBlond = new XMLFeedParser("https://www.anekdot.ru/rss/tag/23.xml");
        xmlFeedBlond.xmlParse();
    }
}
