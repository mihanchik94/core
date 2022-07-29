package io.homework_1.task_3;

import io.homework_1.task_2.GameProgress;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Main {
    public static void main(String[] args) {
        String path = "/IO_task_1_games/savegames/";
        String zipName = "zip.zip";

        openZip(path + zipName, path);
        System.out.println(openProgress("C:\\IO_task_1_games\\savegames\\save2.dat").toString());
    }

    public static void openZip(String zipFile, String path) {
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile))) {
            ZipEntry entry;
            String outputFileName;
            while ((entry = zis.getNextEntry()) != null) {
                outputFileName = path + entry.getName();
                FileOutputStream fos = new FileOutputStream(outputFileName);
                int buff;
                while ((buff = zis.read()) != -1) {
                    fos.write(buff);
                }
                zis.closeEntry();
                fos.close();
                System.out.println("File " + outputFileName + " is unpacked");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static GameProgress openProgress(String path) {
        GameProgress progress = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            progress = (GameProgress) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return progress;
    }
}