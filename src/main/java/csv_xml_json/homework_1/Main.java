package csv_xml_json.homework_1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CSVParser parser = new CSVParser();
        ListToJsonConverter listToJsonConverter = new ListToJsonConverter();
        StringWriter writer = new StringWriter();
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String csvName = "data.csv";
        List<Employee> result = parser.parseCSV(columnMapping, csvName);
        String json = listToJsonConverter.listToJson(result);
        writer.writeString("./data.json", json);
    }
}