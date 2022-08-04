package csv_xml_json.homework_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StringReader {
    public String readString(String fileName) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            reader.lines().forEach(builder::append);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}