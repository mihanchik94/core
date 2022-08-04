package csv_xml_json.homework_2;

import csv_xml_json.homework_1.Employee;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLParser {
    public List<Employee> parseXML(String fileName) {
        List<Employee> result = new ArrayList<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(fileName);
            NodeList employee = doc.getDocumentElement().getElementsByTagName("employee");
            for (int i = 0; i < employee.getLength(); i++) {
                result.add(
                        new Employee(
                                Long.parseLong(findContentByTag(employee.item(i), "id")),
                                findContentByTag(employee.item(i), "firstName"),
                                findContentByTag(employee.item(i), "lastName"),
                                findContentByTag(employee.item(i), "country"),
                                Integer.parseInt(findContentByTag(employee.item(i), "age"))
                        )
                );
            }

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return result;
    }


    public String findContentByTag(Node node, String tag) {
        Element el = (Element) node;
        return el.getElementsByTagName(tag).item(0).getTextContent();
    }
}