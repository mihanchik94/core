package csv_xml_json.homework_3;

public class Main {
    public static void main(String[] args) {
        StringReader reader = new StringReader();
        JsonToListConverter converter = new JsonToListConverter();
        String json = reader.readString("./data.json");
        converter.jsonToList(json).forEach(System.out::println);
    }
}