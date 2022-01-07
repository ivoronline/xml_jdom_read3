import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Main {

  public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

    //CREATE DOCUMENT BUILDER
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder        builder = factory.newDocumentBuilder();

    //SPECIFY XML SOURCE (FILE)
    File                   input = new File("Test.xml");

    //CREATE DOCUMENT
    Document               document  = builder.parse(input);
                           document.getDocumentElement().normalize();

    //ITERATE THROUGH ELEMENTS
    NodeList nodeList = document.getElementsByTagName("person");
    for (int i = 0; i < nodeList.getLength(); i++) {

      //GET NEXT ELEMENT
      Node    node     = nodeList.item(i);
      Element eElement = (Element) node;

      //GET DATA
      String  id   = eElement.getAttribute("id");
      String  name = eElement.getElementsByTagName("name").item(0).getTextContent().trim();
      String  age  = eElement.getElementsByTagName("age" ).item(0).getTextContent().trim();

      //DISPLAY DATA
      System.out.println();
      System.out.println("id  : " + id  );
      System.out.println("name: " + name);
      System.out.println("age : " + age );

    }

  }

}
