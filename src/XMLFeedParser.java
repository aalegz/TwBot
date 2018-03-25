import java.io.IOException;
import java.net.URL;
import java.net.UnknownHostException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class XMLFeedParser
{
    public static String FEEDURL;

    public XMLFeedParser(String FEEDURL) {
        this.FEEDURL = FEEDURL;
    }

    public static void xmlParse()
    {

        try
        {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            System.out.println("Connecting to server");
            Document doc = db.parse(new URL(FEEDURL).openStream());
            System.out.println("Connected");
            System.out.println("");


            doc.getDocumentElement().normalize();



            NodeList nodeList = doc.getElementsByTagName("item");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (1 == node.getNodeType()) {
                    Element element = (Element)node;

                    String str = element.getElementsByTagName("description").item(0).getTextContent().replaceAll("<br>", "\n");
                    System.out.println(str);
                    System.out.println();
                }
            }
        }
        catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            System.out.println("Connection error");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("============== FEED END ==============");
    }
}
