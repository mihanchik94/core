package osi.task_1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int port = 1520;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(port)) {
            while (!server.isClosed()) {
                try (Socket clientSocket = server.accept();
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    System.out.println("New connection accepted");
                    System.out.printf("Client port is %d%n", clientSocket.getPort());

                    final String name = reader.readLine();
                    if (name.equals("close")) {
                        writer.println("Server is closing");
                        server.close();
                    }
                    writer.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}