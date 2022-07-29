package io.homework_1.task_2;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) {
        GameProgress save_1 = new GameProgress(100, 2, 1, 462);
        GameProgress save_2 = new GameProgress(71, 2, 2, 1033);
        GameProgress save_3 = new GameProgress(84, 2, 2, 1215);

        saveGame("C:\\IO_task_1_games\\savegames\\save1.dat", save_1);
        saveGame("C:\\IO_task_1_games\\savegames\\save2.dat", save_2);
        saveGame("C:\\IO_task_1_games\\savegames\\save3.dat", save_3);

        File first = new File("C:\\IO_task_1_games\\savegames\\save1.dat");
        File second = new File("C:\\IO_task_1_games\\savegames\\save2.dat");
        File third = new File("C:\\IO_task_1_games\\savegames\\save3.dat");

        List<String> list = Arrays.asList(first.getAbsolutePath(), second.getAbsolutePath(), third.getAbsolutePath());
        zipFiles("C:\\IO_task_1_games\\savegames\\zip.zip", list);

        System.out.println(first.delete());
        System.out.println(second.delete());
        System.out.println(third.delete());

    }

    public static void saveGame(String path, GameProgress progress) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(progress);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void zipFiles(String path, List<String> files) {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(path))) {
            for (String file : files) {
                try (FileInputStream fis = new FileInputStream(file)) {
                    ZipEntry entry = new ZipEntry(file);
                    zos.putNextEntry(entry);
                    while (fis.available() > 0) {
                        zos.write(fis.read());
                    }
                    zos.closeEntry();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}