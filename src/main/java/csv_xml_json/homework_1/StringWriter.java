package csv_xml_json.homework_1;

import java.io.FileWriter;
import java.io.IOException;

public class StringWriter {
    public void writeString(String path, String str) {
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}