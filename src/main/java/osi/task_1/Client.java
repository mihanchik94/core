package osi.task_1;

import java.io.*;
import java.net.Socket;

public class Client {
    private static final int port = 1520;
    private static final String host = "localhost";

    public static void main(String[] args) {
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            writer.println("Gena");

            String resp = reader.readLine();
            System.out.println(resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}