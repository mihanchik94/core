package osi.task_2;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final int port = 1164;
    private static final String host = "netology.homework";

    public static void main(String[] args) {
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println(reader.readLine());
                String name = scanner.nextLine();
                writer.println(name);
                if (name.equals("close")) {
                    //writer.println(name);
                    break;
                }

                String serverAnswer = reader.readLine();
                System.out.println(serverAnswer);
                String userAdult = scanner.nextLine();
                writer.println(userAdult);
                if (userAdult.equals("close") || userAdult.equals("yes") || userAdult.equals("no")) {
                    System.out.println(reader.readLine());
                    break;
                }
                System.out.println(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}