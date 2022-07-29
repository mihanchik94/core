package io.homework_1.task_1;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private static final LocalDateTime dateTime = LocalDateTime.now();
    private static final StringBuilder builder = new StringBuilder();

    public static void main(String[] args) {
        File root = new File("/IO_task_1_games");
        List<File> directories = Arrays.asList(
                new File(root + "/src"),
                new File(root + "/res"),
                new File(root + "/savegames"),
                new File(root + "/temp"),
                new File(root + "/src/main"),
                new File(root + "/src/test"),
                new File(root + "/res/drawables"),
                new File(root + "/res/vectors"),
                new File(root + "/res/icons")
        );
        List<File> files = Arrays.asList(
                new File(root + "/src/main/Main.java"),
                new File(root + "/src/main/Utils.java"),
                new File(root + "/temp/temp.txt")
        );

        directories.forEach(dir -> {
            if (dir.mkdir()) {
                builder.append(dateTime.format(formatter)).append(" Directory ").append(dir.getName()).append(" is created \n");
            } else {
                builder.append(dateTime.format(formatter)).append(" Error! Directory ").append(dir.getName()).append(" IS NOT CREATED \n");
            }
        }
        );

        files.forEach(file -> {
            try {
                if (file.createNewFile()) {
                    builder.append(dateTime.format(formatter)).append(" File ").append(file.getName()).append(" is created \n");
                }
            } catch (IOException e) {
                builder.append(e.getMessage()).append("\n");
            }
        }
        );

        try (FileWriter writer = new FileWriter(root + "/temp/temp.txt")) {
            writer.write(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(root + "/temp/temp.txt"))) {
            String text;
            while ((text = reader.readLine()) != null) {
                System.out.println(text);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}