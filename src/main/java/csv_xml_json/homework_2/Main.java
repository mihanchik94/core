package csv_xml_json.homework_2;

import csv_xml_json.homework_1.Employee;
import csv_xml_json.homework_1.ListToJsonConverter;
import csv_xml_json.homework_1.StringWriter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListToJsonConverter converter = new ListToJsonConverter();
        XMLParser parser = new XMLParser();
        StringWriter writer = new StringWriter();

        List<Employee> list = parser.parseXML("data.xml");
        String json = converter.listToJson(list);
        writer.writeString("./data_from_xml.json", json);

    }
}