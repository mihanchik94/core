package csv_xml_json.homework_1;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {
    public List<Employee> parseCSV(String[] columns, String fileName) {
        List<Employee> result = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            ColumnPositionMappingStrategy<Employee> strategy = new ColumnPositionMappingStrategy<>();
            strategy.setType(Employee.class);
            strategy.setColumnMapping(columns);
            CsvToBean<Employee> csvToBean = new CsvToBeanBuilder<Employee>(reader).withMappingStrategy(strategy).build();
            result = csvToBean.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
